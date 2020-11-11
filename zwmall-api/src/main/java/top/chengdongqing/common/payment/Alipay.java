package top.chengdongqing.common.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSON;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.HttpKit;
import top.chengdongqing.common.kit.SignatureKit;
import top.chengdongqing.portal.order.bo.PayInfo;

/**
 * 支付宝支付
 * 
 * @author Luyao
 *
 */
public class Alipay implements IPayment {

	private static final IPayment me = new Alipay();

	public static IPayment me() {
		return me;
	}

	// 配置文件
	private static final Prop prop = PropKit.use(ConfigFile.ALIPAY);

	// 公用常量
	private interface Const {
		String APP_ID = prop.get("app.id");
		String VERSION = prop.get("method.version");
		String SIGN_TYPE = prop.get("sign.type");
		String PRIVATE_KEY = prop.get("key.private");
		String HTTP_URL = prop.get("http.url");
	}

	// 支付宝响应状态
	private interface Status {
		String SUCCESS = "10000";
		String TRADE_SUCCESS = "TRADE_SUCCESS";
	}

	@Override
	@SuppressWarnings("unchecked")
	public Ret requestPayment(String orderNo, BigDecimal amount, String ip) {
		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<>();
		params.put("app_id", Const.APP_ID);
		params.put("method", prop.get("method.name.pay"));
		params.put("version", Const.VERSION);
		params.put("charset", Constant.CHARSET);
		params.put("sign_type", Const.SIGN_TYPE);
		params.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		params.put("notify_url", prop.get("notify.url"));
		// 业务内容
		Kv bizContent = Kv.by("out_trade_no", orderNo).set("total_amount", amount.toString());
		bizContent.set("subject", prop.get("product.name")).set("timeout_express", "30m");
		params.put("biz_content", bizContent.toJson());
		params.put("sign", SignatureKit.rsa256Sign(params, Const.PRIVATE_KEY));

		try {
			// 发送付款请求
			String result = HttpKit.get(Const.HTTP_URL, params);

			// 将JSON字符串转map对象
			Kv resultMap = JSON.parseObject(result, Kv.class);
			resultMap = JSON.parseObject(resultMap.getStr("alipay_trade_precreate_response"), Kv.class);

			// 判断处理结果是否成功
			if (isSuccess(resultMap)) {
				// 返回二维码链接
				return Ret.ok("url", resultMap.get("qr_code"));
			}
			return Fail.setMsg(buildMsg(resultMap));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Ret handleCallback(Map<String, String> params) {
		// 返回给支付宝服务器的处理结果
		final String returnCode = "success";

		if (params.isEmpty() || StrKit.isBlank(params.get("sign"))) {
			return Fail.setMsg(returnCode);
		}

		// 校验签名
		if (SignatureKit.rsa256Verify(params, prop.get("key.alipay.public"), params.get("sign"))) {
			return Fail.setMsg(returnCode);
		}

		// 校验支付结果
		if (!Status.TRADE_SUCCESS.equals(params.get("trade_status"))) {
			return Fail.setMsg(returnCode);
		}

		// 封装支付信息
		PayInfo payInfo = new PayInfo();
		payInfo.setOrderNo(params.get("out_trade_no"));
		payInfo.setPaymentNo(params.get("trade_no"));
		payInfo.setPayAmount(new BigDecimal(params.get("total_amount")));
		LocalDateTime paymentTime = LocalDateTime.parse(params.get("gmt_payment"),
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		payInfo.setPaymentTime(Date.from(paymentTime.atZone(ZoneId.systemDefault()).toInstant()));
		return Ret.ok("payInfo", payInfo).set(Constant.MSG, returnCode);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Ret requestCancel(String orderNo) {
		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<String, String>();
		params.put("app_id", Const.APP_ID);
		params.put("method", prop.get("method.name.cancel"));
		params.put("version", Const.VERSION);
		params.put("charset", Constant.CHARSET);
		params.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		params.put("sign_type", Const.SIGN_TYPE);
		// 业务参数
		params.put("biz_content", Kv.by("out_trade_no", orderNo).toJson());
		params.put("sign", SignatureKit.rsa256Sign(params, Const.PRIVATE_KEY));

		try {
			String result = HttpKit.get(Const.HTTP_URL, params);
			// 将JSON字符串转map对象
			Kv resultMap = JSON.parseObject(result, Kv.class);
			resultMap = JSON.parseObject(resultMap.getStr("alipay_trade_close_response"), Kv.class);

			// 判断处理结果是否成功
			if (isSuccess(resultMap)) {
				return Ret.ok();
			}
			return Fail.setMsg(buildMsg(resultMap));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Ret requestRefund(String orderNo, BigDecimal totalAmount, BigDecimal refundAmount) {
		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<String, String>();
		params.put("app_id", Const.APP_ID);
		params.put("method", prop.get("method.name.refund"));
		params.put("version", Const.VERSION);
		params.put("charset", Constant.CHARSET);
		params.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		params.put("sign_type", Const.SIGN_TYPE);
		// 业务参数
		Kv bizContent = Kv.by("out_trade_no", orderNo).set("refund_amount", refundAmount.toString());
		params.put("biz_content", bizContent.toJson());
		params.put("sign", SignatureKit.rsa256Sign(params, Const.PRIVATE_KEY));

		try {
			String result = HttpKit.get(Const.HTTP_URL, params);
			// 将JSON字符串转map对象
			Kv resultMap = JSON.parseObject(result, Kv.class);
			resultMap = JSON.parseObject(resultMap.getStr("alipay_trade_refund_response"), Kv.class);

			// 判断处理结果是否成功
			if (isSuccess(resultMap)) {
				return Ret.ok();
			}
			return Fail.setMsg(buildMsg(resultMap));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String buildMsg(Map<String, String> resultMap) {
		return resultMap.get("return_msg") != null ? resultMap.get("return_msg") : resultMap.get("err_code_des");
	}

	/**
	 * 校验处理结果
	 * 
	 * @param resultMap
	 * @return
	 */
	private boolean isSuccess(Kv resultMap) {
		return Status.SUCCESS.equals(resultMap.get("code"));
	}
}

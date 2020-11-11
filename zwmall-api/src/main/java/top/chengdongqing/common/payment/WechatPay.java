package top.chengdongqing.common.payment;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.HttpKit;
import top.chengdongqing.common.kit.SignatureKit;
import top.chengdongqing.common.kit.XmlKit;
import top.chengdongqing.portal.order.bo.PayInfo;

/**
 * 微信支付
 * 
 * @author Luyao
 *
 */
public class WechatPay implements IPayment {

	private static final IPayment me = new WechatPay();

	public static IPayment me() {
		return me;
	}

	// 配置文件
	private static final Prop prop = PropKit.use(ConfigFile.WECHAT);

	// 公用常量
	private interface Const {
		String APP_ID = prop.get("app.id");
		String MCH_ID = prop.get("mch.id");
		String SIGN_KEY = prop.get("sign.key");
	}

	// 微信支付状态
	private interface Status {
		String SUCCESS = "SUCCESS";
		String FAIL = "FAIL";
	}

	@Override
	public Ret requestPayment(String orderNo, BigDecimal amount, String ip) {
		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<String, String>();
		params.put("appid", Const.APP_ID);
		params.put("mch_id", Const.MCH_ID);
		params.put("nonce_str", StrKit.getRandomUUID());
		params.put("body", prop.get("product.name"));
		params.put("out_trade_no", orderNo);
		params.put("total_fee", String.valueOf(amount.multiply(new BigDecimal("100")).intValue()));
		params.put("spbill_create_ip", ip);
		String timeExpire = LocalDateTime.now().plusMinutes(30).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		params.put("time_expire", timeExpire);
		params.put("notify_url", prop.get("notify.url"));
		params.put("trade_type", prop.get("trade.type"));
		params.put("key", Const.SIGN_KEY);
		params.put("sign", SignatureKit.md5Sign(params));
		params.remove("key");

		try {
			// 将map转为xml
			String xml = XmlKit.mapToXml(params);
			// 发送付款请求
			String result = HttpKit.post(prop.get("pay.url"), xml);

			// 转换结果格式
			Map<String, String> resultMap = XmlKit.xmlToMap(result);

			// 判断处理结果是否成功
			if (isSuccess(resultMap)) {
				// 返回二维码链接
				return Ret.ok("url", resultMap.get("code_url"));
			}
			return Fail.setMsg(buildMsg(resultMap));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public Ret handleCallback(Map<String, String> params) {
		// 返回给微信的xml标签
		final String returnCode = "return_code";
		final String returnMsg = "return_msg";

		if (params.isEmpty() || StrKit.isBlank(params.get("sign"))) {
			return Fail.setMsg(XmlKit.mapToXml(Kv.by(returnCode, Status.FAIL).set(returnMsg, "参数错误")));
		}

		// 校验签名
		params.put("key", prop.get("sign.key"));
		boolean verifySuccess = SignatureKit.md5Sign(params).equalsIgnoreCase(params.get("sign"));
		if (!verifySuccess) {
			return Fail.setMsg(XmlKit.mapToXml(Kv.by(returnCode, Status.FAIL).set(returnMsg, "验签失败")));
		}

		// 校验支付结果
		if (!Status.SUCCESS.equals(params.get("result_code"))) {
			return Fail.setMsg(XmlKit.mapToXml(Kv.by(returnCode, Status.FAIL).set(returnMsg, "支付失败")));
		}

		// 封装支付信息
		PayInfo payInfo = new PayInfo();
		payInfo.setOrderNo(params.get("out_trade_no"));
		payInfo.setPaymentNo(params.get("transaction_id"));
		BigDecimal payAmount = new BigDecimal(params.get("total_fee")).divide(new BigDecimal("100"));
		payInfo.setPayAmount(payAmount.setScale(2, RoundingMode.HALF_UP));
		LocalDateTime paymentTime = LocalDateTime.parse(params.get("time_end"),
				DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		payInfo.setPaymentTime(Date.from(paymentTime.atZone(ZoneId.systemDefault()).toInstant()));
		return Ret.ok("payInfo", payInfo).set(Constant.MSG, XmlKit.mapToXml(Kv.by(returnCode, Status.SUCCESS)));
	}

	@Override
	public Ret requestCancel(String orderNo) {
		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<String, String>();
		params.put("appid", prop.get("app.id"));
		params.put("mch_id", prop.get("mch.id"));
		params.put("nonce_str", StrKit.getRandomUUID());
		params.put("out_trade_no", orderNo);
		params.put("key", prop.get("sign.key"));
		params.put("sign", SignatureKit.md5Sign(params));
		params.remove("key");

		try {
			// 将map转为xml
			String xml = XmlKit.mapToXml(params);
			// 发送取消请求
			String result = HttpKit.post(prop.get("cancel.url"), xml);

			// 转换结果格式
			Map<String, String> resultMap = XmlKit.xmlToMap(result);

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
	public Ret requestRefund(String orderNo, BigDecimal totalAmount, BigDecimal refundAmount) {
		// 总金额
		String totalFee = String.valueOf(totalAmount.multiply(new BigDecimal("100")).intValue());
		// 退款金额
		String refundFee = String.valueOf(refundAmount.multiply(new BigDecimal("100")).intValue());

		// 封装请求参数
		Map<String, String> params = new ConcurrentHashMap<String, String>();
		params.put("appid", prop.get("app.id"));
		params.put("mch_id", prop.get("mch.id"));
		params.put("nonce_str", StrKit.getRandomUUID());
		params.put("out_trade_no", orderNo);
		params.put("out_refund_no", orderNo);
		params.put("total_fee", totalFee);
		params.put("refund_fee", refundFee);
		params.put("key", prop.get("sign.key"));
		params.put("sign", SignatureKit.md5Sign(params));
		params.remove("key");

		try {
			// 获取证书文件路径
			File cert = new File(PathKit.getRootClassPath() + prop.get("refund.cert.path"));
			// 获取证书密码字符数组
			char[] password = prop.get("mch.id").toCharArray();
			String result = HttpKit.postWithCert(prop.get("refund.url"), XmlKit.mapToXml(params), cert, password);

			// 将请求结果的数据类型由xml转为map
			Map<String, String> resultMap = XmlKit.xmlToMap(result);

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
	private boolean isSuccess(Map<String, String> resultMap) {
		return Status.SUCCESS.equals(resultMap.get("return_code"))
				&& Status.SUCCESS.equals(resultMap.get("result_code"));
	}
}

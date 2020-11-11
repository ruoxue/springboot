package top.chengdongqing.portal.order.pay;

import java.net.URLDecoder;
import java.nio.charset.Charset;

import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.AccessLimit;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.interceptor.LoginAuthInterceptor;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.HttpKit;

/**
 * 订单支付相关控制器
 * 
 * @author Luyao
 *
 */
public class PayController extends BaseController {

	@Inject
	PayService paySrv;

	/**
	 * 查询订单基础信息
	 * 
	 * @param orderNo
	 */
	@Before(GET.class)
	@NotBlank("orderNo")
	public void details(String orderNo) {
		renderJson(paySrv.findDetails(orderNo, getUserId()));
	}

	/**
	 * 请求订单付款
	 * 
	 * @param orderNo
	 * @param payMode
	 */
	@Before(POST.class)
	@NotBlank({ "orderNo", "payMode" })
	public void index(String orderNo, int payMode) {
		renderJson(paySrv.requestPayment(orderNo, payMode, getUserId(), getIp()));
	}

	/**
	 * 将指定的内容转为二维码图片
	 * 
	 * @param code
	 */
	@AccessLimit
	@Before(GET.class)
	@NotBlank("content")
	@Clear(LoginAuthInterceptor.class)
	public void qrcode() {
		String code = get("content", Fail.Msg.PARAM_EMPTY);
		code = URLDecoder.decode(code, Charset.forName(Constant.CHARSET));
		renderQrCode(code, 300, 300);
	}

	/**
	 * 微信支付回调
	 */
	@Before(POST.class)
	@Clear(LoginAuthInterceptor.class)
	public void wechatCallback() {
		String xml = HttpKit.readBuffer(getRequest());
		renderText(paySrv.paymentCallback(xml, null).getStr(Constant.MSG));
	}

	/**
	 * 支付宝支付回调
	 */
	@Before(POST.class)
	@Clear(LoginAuthInterceptor.class)
	public void alipayCallback() {
		renderText(paySrv.paymentCallback(null, getKv()).getStr(Constant.MSG));
	}
}

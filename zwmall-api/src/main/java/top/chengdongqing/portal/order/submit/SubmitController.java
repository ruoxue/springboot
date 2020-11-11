package top.chengdongqing.portal.order.submit;

import java.math.BigDecimal;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;

/**
 * 订单提交相关控制器
 * 
 * @author Luyao
 *
 */
public class SubmitController extends BaseController {

	@Inject
	SubmitService submitSrv;

	/**
	 * 获取订单邮费
	 * 
	 * @param goodsAmount
	 */
	@Before(GET.class)
	public void expressFee(BigDecimal goodsAmount) {
		renderJson(submitSrv.getExpressFee(goodsAmount));
	}

	/**
	 * 提交订单
	 * 
	 * @param addressId
	 */
	@Before(POST.class)
	@NotBlank("addressId")
	public void index(int addressId) {
		renderJson(submitSrv.submit(addressId, getUserId()));
	}
}

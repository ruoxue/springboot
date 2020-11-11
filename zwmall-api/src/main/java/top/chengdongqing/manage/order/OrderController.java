package top.chengdongqing.manage.order;

import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import com.jfinal.kit.Ret;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.model.GoodsSku;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.OrderExpress;
import top.chengdongqing.common.model.UserAddress;
import top.chengdongqing.common.render.StreamRender;
import top.chengdongqing.portal.cart.CartService;
import top.chengdongqing.portal.goods.GoodsService;
import top.chengdongqing.portal.order.submit.SubmitService;
import top.chengdongqing.portal.user.address.AddressService;

/**
 * 订单管理相关控制器
 * 
 * @author Luyao
 *
 */
public class OrderController extends BaseController {

	@Inject
	OrderService orderSrv;

	/**
	 * 查询订单
	 */
	@Before(GET.class)
	public void index(String keyword, Date startDate, Date endDate) {
		int status = getInt("status", -1);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(orderSrv.paginate(keyword, status, startDate, endDate, pageNumber, pageSize));
	}


	/**
	 * 查询订单详情
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(GET.class)
	public void details(int id) {
		renderJson(orderSrv.findDetails(id));
	}

	/**
	 * 确认已配货
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void prepared(int id) {
		renderJson(orderSrv.orderPrepared(id));
	}

	/**
	 * 确认已发货
	 * 
	 * @param orderId
	 * @param express
	 */
	@Before({ POST.class, ShippedValidator.class })
	public void shipped(int orderId, @Para("") OrderExpress express) {
		renderJson(orderSrv.orderShipped(orderId, express, getUserId()));
	}

	/**
	 * 订单退款处理
	 * 
	 * @param id
	 * @param remark
	 */
	@NotBlank
	@Before(POST.class)
	public void refund(int id, String remark) {
		renderJson(orderSrv.orderRefund(id, remark));
	}

	/**
	 * 导出订单excel
	 * 
	 * @param keyword
	 * @param startDate
	 * @param endDate
	 */
	@Before(GET.class)
	@NotBlank({ "startDate", "endDate" })
	public void exportExcel(String keyword, Date startDate, Date endDate) {
		int status = getInt("status", -1);
		byte[] bytes = orderSrv.getOrdersExcel(status, keyword, startDate, endDate);
		render(new StreamRender(bytes, "订单报表.xlsx"));
	}
}

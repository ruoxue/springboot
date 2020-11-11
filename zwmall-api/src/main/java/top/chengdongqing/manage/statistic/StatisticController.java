package top.chengdongqing.manage.statistic;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.GET;

import top.chengdongqing.common.config.Constant;

/**
 * 统计相关控制器
 * 
 * @author Luyao
 *
 */
public class StatisticController extends Controller {

	@Inject
	StatisticService statisticSrv;

	/**
	 * 统计订单成交数据
	 */
	@Before(GET.class)
	public void paidAmounts() {
		renderJson(statisticSrv.findPaidAmounts());
	}

	/**
	 * 核心数据统计
	 */
	@Before(GET.class)
	public void cores() {
		renderJson(statisticSrv.findCoreStatistics());
	}

	/**
	 * 查询商品销售排行榜
	 */
	@Before(GET.class)
	public void goodsSalesRank() {
		renderJson(statisticSrv.findSalesRank());
	}

	/**
	 * 查询品牌销售情况
	 */
	@Before(GET.class)
	public void brandSalesRank() {
		renderJson(statisticSrv.findBrandSalesRank());
	}

	/**
	 * 查询库存紧张的商品
	 */
	@Before(GET.class)
	public void warningGoodses(String keyword) {
		int status = getInt("status", 0);
		int pageNumber = getInt("pageNumber", 1);
		int pageSize = getInt("pageSize", 10);
		renderJson(statisticSrv.findWarningGoodses(keyword, status, pageNumber, pageSize));
	}

	/**
	 * 重定向到连接池监控页面
	 */
	@Before(GET.class)
	public void druid() {
		String token = get(Constant.TOKEN);
		getRequest().getSession().setAttribute(Constant.TOKEN, token);
		redirect("/druid");
	}
}

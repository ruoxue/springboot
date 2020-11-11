package top.chengdongqing.common.config;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;

import top.chengdongqing.common.controller.FileController;
import top.chengdongqing.common.interceptor.AccessLimitInterceptor;
import top.chengdongqing.common.interceptor.CrossDomainInterceptor;
import top.chengdongqing.common.interceptor.NotBlankInterceptor;
import top.chengdongqing.common.model._Generator;
import top.chengdongqing.common.model._MappingKit;
import top.chengdongqing.manage.common.ManageRoutes;
import top.chengdongqing.portal.common.PortalRoutes;
import top.chengdongqing.portal.order.OrderCancelTask;
import top.chengdongqing.portal.order.OrderSubmitTask;

/**
 * 应用核心配置
 * 
 * @author Luyao
 *
 */
public class AppConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// 设置是否为开发模式
		me.setDevMode(Constant.DEV_MODE);
		// 设置文件上传基础路径
		me.setBaseUploadPath(Constant.UPLOAD_BASE_PATH);
		// 设置上传的最大数据量
		me.setMaxPostSize(1024 * 1024 * 100);
		// 开启依赖注入
		me.setInjectDependency(true);
	}

	@Override
	public void configRoute(Routes me) {
		// 用户相关路由
		me.add(new PortalRoutes());
		// 管理相关路由
		me.add(new ManageRoutes());

		// 文件访问，仅开发阶段使用
		if (Constant.DEV_MODE) {
			me.add("file", FileController.class);
		}
	}

	@Override
	public void configEngine(Engine me) {

	}

	@Override
	public void configPlugin(Plugins me) {
		// 配置数据库连接池插件
		DruidPlugin druid = _Generator.getDruidPlugin();
		WallFilter wallFilter = new WallFilter();
		wallFilter.setDbType("mysql");
		druid.addFilter(wallFilter).addFilter(new StatFilter());
		me.add(druid);

		// 配置操作数据库插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
		arp.setBaseSqlTemplatePath("/template");
		arp.addSqlTemplate("/portal/init.sql");
		arp.addSqlTemplate("/manage/init.sql");
		arp.getEngine().setCompressorOn(' ');
		arp.setShowSql(Constant.DEV_MODE);
		_MappingKit.mapping(arp);
		me.add(arp);

		// 添加本地缓存插件
		me.add(new EhCachePlugin());

		// 添加定时器
		Cron4jPlugin cp = new Cron4jPlugin();
		// 每5分钟执行一次
		cp.addTask("*/5 * * * *", new OrderCancelTask());
		cp.addTask("*/5 * * * *", new OrderSubmitTask());

		me.add(cp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// 允许跨域拦截器
		me.addGlobalActionInterceptor(new CrossDomainInterceptor());
		// 参数非空拦截器
		me.addGlobalActionInterceptor(new NotBlankInterceptor());
		// 访问限制拦截器
		me.addGlobalActionInterceptor(new AccessLimitInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// 数据库连接池统计页面处理器
		DruidStatViewHandler dsvHandler = new DruidStatViewHandler("/druid", (HttpServletRequest request) -> {
			return request.getSession().getAttribute(Constant.TOKEN) != null;
		});
		me.add(dsvHandler);
	}
}

package top.chengdongqing.common.model;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import top.chengdongqing.common.config.Constant.ConfigFile;

/**
 * Model、BaseModel、_MappingKit 生成器
 *
 */
public class _Generator {

	/**
	 * 生成入口
	 */
	public static void main(String[] args) {
		// base model 所使用的包名
		String baseModelPackageName = "top.chengdongqing.common.model.base";
		// base model 文件保存路径
		String baseModelOutputDir = PathKit.getWebRootPath() + "/src/main/java/top/chengdongqing/common/model/base";
		// model 所使用的包名 (MappingKit 默认使用的包名)
		String modelPackageName = "top.chengdongqing.common.model";
		// model 文件保存路径 (MappingKit 与 DataDictionary 文件默认保存路径)
		String modelOutputDir = baseModelOutputDir + "/..";
		// 实例化生成器
		Generator gen = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName,
				modelOutputDir);
		// 配置数据库方言
		gen.setDialect(new MysqlDialect());

		// 生成字段备注
		gen.setGenerateRemarks(true);
		// 执行生成
		gen.generate();
	}

	/**
	 * 数据源配置
	 */
	public static DataSource getDataSource() {
		DruidPlugin druidPlugin = getDruidPlugin();
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}

	/**
	 * 获取数据库连接池对象
	 * 
	 * @return
	 */
	public static DruidPlugin getDruidPlugin() {
		Prop prop = PropKit.use(ConfigFile.APPLICATION);
		return new DruidPlugin(prop.get("mysql.jdbcUrl"), prop.get("mysql.username"), prop.get("mysql.password"));
	}
}

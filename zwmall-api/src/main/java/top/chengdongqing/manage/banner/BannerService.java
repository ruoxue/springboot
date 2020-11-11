package top.chengdongqing.manage.banner;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Kv;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Banner;

/**
 * 横幅管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class BannerService {

	@Inject
	Banner dao;

	/**
	 * 获取横幅
	 * 
	 * @return
	 */
	public List<Banner> findBanners(String type) {
		String sql = "select * from banner where type = ? order by categoryId, sortNo desc";
		return dao.find(sql, type);
	}

	/**
	 * 更新横幅状态
	 * 
	 * @param id
	 * @return
	 */
	public Ret updateStatus(int id) {
		Banner banner = getBannerById(id);
		banner.setStatus(banner.getStatus() == 0 ? 1 : 0);
		return banner.update() && removeCache(banner.getType()) ? Ret.ok() : Fail.setMsg(Fail.Msg.OPERATION_FAIL);
	}

	/**
	 * 清除缓存
	 * 
	 * @param type
	 * @return
	 */
	private boolean removeCache(String type) {
		CacheKit.remove(CacheKey.MEDIA, "banner_" + type);
		return true;
	}

	/**
	 * 根据id查询横幅
	 * 
	 * @param id
	 * @return
	 */
	private Banner getBannerById(int id) {
		Banner banner = dao.findByIdLoadColumns(id, "id, status, type, categoryId, sortNo");
		if (banner == null) {
			throw new IllegalStateException("The banner is not exist");
		}
		return banner;
	}

	/**
	 * 删除横幅
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteBanner(int id) {
		Banner banner = getBannerById(id);
		// 查询同类型的横幅数量
		String sql = "select count(*) from banner where type = #para(type) #if(categoryId) and categoryId = #para(categoryId) #end";
		int count = Db.templateByString(sql, Kv.by("type", banner.getType()).set("categoryId", banner.getCategoryId())).queryInt();

		// 根据不同类型判断最少需保留的数量
		int keepCount = 0;
		switch (banner.getType()) {
		case Banner.Type.SLIDE -> keepCount = 1;
		case Banner.Type.PROMO -> keepCount = 3;
		case Banner.Type.ADVERT -> keepCount = 7;
		case Banner.Type.CATEGORY -> keepCount = 1;
		}
		if (count <= keepCount) {
			return Fail.setMsg("请至少保留%d张图片".formatted(keepCount));
		}

		// 执行删除
		return banner.delete() && removeCache(banner.getType()) ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 更新横幅
	 * 
	 * @param banner
	 * @return
	 */
	public Ret updateBanner(Banner banner) {
		banner.remove("createTime", "status");
		// 如果是商品类别广告，查询商品类别名称
		if (banner.getType().equals(Banner.Type.CATEGORY)) {
			banner.setCategoryName(getCategoryName(banner.getCategoryId()));
		}
		return banner.update() && removeCache(banner.getType()) ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 新增横幅
	 * 
	 * @param banner
	 * @return
	 */
	public Ret saveBanner(Banner banner) {
		// 查询当前最大的排序号
		String sql = "select sortNo from banner where type = ? order by sortNo desc limit 1";
		Integer maxSortNo = Db.queryInt(sql, banner.getType());
		banner.setSortNo(maxSortNo != null ? maxSortNo + 1 : 0);
		// 清除无用信息
		banner.remove("id", "createTime", "status");
		// 如果是商品类别广告，查询商品类别名称
		if (banner.getType().equals(Banner.Type.CATEGORY)) {
			banner.setCategoryName(getCategoryName(banner.getCategoryId()));
		}
		return banner.save() && removeCache(banner.getType()) ? Ret.ok() : Fail.setMsg(Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 根据id查询类别名称
	 * 
	 * @param id
	 * @return
	 */
	private String getCategoryName(int id) {
		return Db.queryStr("select name from goods_category where id = ? limit 1", id);
	}

	/**
	 * 横幅排序
	 * 
	 * @param id
	 * @param direction
	 * @return
	 */
	public Ret bannerSort(int id, int direction) {
		Banner banner = getBannerById(id);

		// direction等于0为上移，获取该类别的上一个类别，否则相反
		StringBuilder sql = new StringBuilder("select id, sortNo from banner where type = ? and sortNo ");
		sql.append(direction == 0 ? "<" : ">").append(" ? order by sortNo ");
		sql.append(direction == 0 ? "desc" : "asc").append(" limit 1");
		Banner brotherBanner = dao.findFirst(sql.toString(), banner.getType(), banner.getSortNo());
		if (brotherBanner == null) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 交换排序号
		int sortNo = brotherBanner.getSortNo();
		brotherBanner.setSortNo(banner.getSortNo());
		banner.setSortNo(sortNo);
		boolean isOk = Db.tx(() -> {
			return banner.update() && brotherBanner.update();
		});
		return isOk && removeCache(banner.getType()) ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}
}

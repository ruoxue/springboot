package top.chengdongqing.portal.banner;

import java.util.List;

import com.jfinal.aop.Inject;

import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.model.Banner;

/**
 * 轮播图相关逻辑层
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
		String sql = "select pictureUrl, linkMode, linkUrl, goodsId from banner where type = ? and status = ? order by sortNo desc, createTime desc";
		return dao.findByCache(CacheKey.MEDIA, "banner_" + type, sql, type, Status.ENABLED);
	}
}

package top.chengdongqing.portal.video;

import java.util.List;

import com.jfinal.aop.Inject;

import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.model.Video;

/**
 * 视频相关业务层
 * 
 * @author Luyao
 *
 */
public class VideoService {

	@Inject
	Video dao;

	/**
	 * 获取视频列表
	 * 
	 * @param all
	 * @return
	 */
	public List<Video> findAll(Boolean all) {
		String sql = "select name, title, coverUrl, videoUrl from video where status = ? order by sortNo desc, createTime desc";
		if (!all) {
			sql += " limit 4";
		}
		return dao.findByCache(CacheKey.MEDIA, all ? "allVideo" : "video", sql, Status.ENABLED);
	}
}

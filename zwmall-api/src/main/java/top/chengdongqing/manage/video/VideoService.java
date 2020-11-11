package top.chengdongqing.manage.video;

import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Video;

/**
 * 视频管理相关逻辑层
 * 
 * @author Luyao
 *
 */
public class VideoService {

	@Inject
	private Video dao;

	/**
	 * 查询视频列表
	 * 
	 * @return
	 */
	public List<Video> findAll() {
		String sql = "select * from video order by sortNo desc";
		return dao.find(sql);
	}

	/**
	 * 更新视频状态
	 * 
	 * @param id
	 * @return
	 */
	public Ret updateStatus(int id) {
		Video video = getVideoById(id);
		video.setStatus(video.getStatus() == 0 ? 1 : 0);
		return video.update() && clearCache() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 清除缓存
	 * 
	 * @return
	 */
	private boolean clearCache() {
		CacheKit.remove(CacheKey.MEDIA, "video");
		CacheKit.remove(CacheKey.MEDIA, "allVideo");
		return true;
	}

	/**
	 * 根据id查询视频
	 * 
	 * @param id
	 * @return
	 */
	private Video getVideoById(int id) {
		Video video = dao.findByIdLoadColumns(id, "id, status, sortNo");
		if (video == null) {
			throw new IllegalStateException("The video is not exist");
		}
		return video;
	}

	/**
	 * 删除视频
	 * 
	 * @param id
	 * @return
	 */
	public Ret deleteVideo(int id) {
		Video video = getVideoById(id);

		// 查询当前视频数量
		int count = Db.queryInt("select count(*) from video");
		if (count <= 4) {
			return Fail.setMsg("请至少保留4个视频");
		}

		return video.delete() ? Ret.ok() : Fail.setMsg(Fail.Msg.DELETE_FAIL);
	}

	/**
	 * 添加视频
	 * 
	 * @param video
	 * @return
	 */
	public Ret saveVideo(Video video) {
		// 查询当前最大的排序号
		String sql = "select sortNo from video order by sortNo desc limit 1";
		Integer maxSortNo = Db.queryInt(sql);
		// 清除无用信息
		video.remove("id", "createTime", "status");
		// 保存视频
		video.setSortNo(maxSortNo != null ? maxSortNo + 1 : 0);
		return video.save() && clearCache() ? Ret.ok() : Fail.setMsg(Fail.Msg.SAVE_FAIL);
	}

	/**
	 * 更新视频
	 * 
	 * @param video
	 * @return
	 */
	public Ret updateVideo(Video video) {
		video.remove("createTime", "status");
		return video.update() && clearCache() ? Ret.ok() : Fail.setMsg(Fail.Msg.UPDATE_FAIL);
	}

	/**
	 * 视频排序
	 * 
	 * @param id
	 * @param direction
	 * @return
	 */
	public Ret videoSort(int id, int direction) {
		Video video = getVideoById(id);

		// direction等于0为上移，获取该类别的上一个类别，否则相反
		StringBuilder sql = new StringBuilder("select id, sortNo from video where sortNo ");
		sql.append(direction == 0 ? "<" : ">").append(" ? order by sortNo ");
		sql.append(direction == 0 ? "desc" : "asc").append(" limit 1");
		Video nearbyVideo = dao.findFirst(sql.toString(), video.getSortNo());
		if (nearbyVideo == null) {
			return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
		}

		// 交换排序号
		int sortNo = nearbyVideo.getSortNo();
		nearbyVideo.setSortNo(video.getSortNo());
		video.setSortNo(sortNo);
		boolean isOk = Db.tx(() -> {
			return video.update() && nearbyVideo.update();
		});
		return isOk && clearCache() ? Ret.ok() : Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
	}
}

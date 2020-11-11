package top.chengdongqing.portal.user.profile;

import java.io.File;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.model.User;
import top.chengdongqing.common.uploader.Uploader.SaveDire;

/**
 * 个人资料相关控制器
 * 
 * @author Luyao
 *
 */
public class ProfileController extends BaseController {

	@Inject
	ProfileService profileSrv;

	/**
	 * 更新个人资料
	 * 
	 * @param user
	 */
	@Before({ POST.class, ProfileValidator.class })
	public void update(@Para("") User user) {
		renderJson(profileSrv.update(user, getUser()));
	}

	/**
	 * 更新头像
	 */
	@Before(POST.class)
	public void updateAvatar() {
		File avatar = getFile(SaveDire.AVATAR).getFile();
		renderJson(profileSrv.updateAvatar(avatar, getUser()));
	}

	/**
	 * 查询用户相关数量信息
	 */
	@Before(GET.class)
	public void counts() {
		renderJson(profileSrv.findCounts(getUserId()));
	}
}

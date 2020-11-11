package top.chengdongqing.portal.user.register;

import com.jfinal.aop.Inject;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Ret;

import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.portal.user.login.LoginService;

import static top.chengdongqing.common.model.User.securityLevel.DANGEROUS;

/**
 * 注册相关逻辑层
 *
 * @author Luyao
 */
public class RegisterService {

    @Inject
    LoginService loginSrv;

    /**
     * 账号注册
     *
     * @param phone
     * @param password
     * @param ip
     * @param sureHasnot
     * @return
     */
    public Ret register(String phone, String password, String ip, boolean sureHasnot) {
        // 判断该手机号是否存在
        if (!sureHasnot && loginSrv.hasAccount(phone)) {
            return Fail.setMsg("该账号已存在，请直接登录");
        }

        // 保存用户信息
        User user = new User();
        user.setPhone(phone);
        user.setSalt(HashKit.generateSaltForSha256());
        user.setPassword(HashKit.sha256(password + user.getSalt()));
        user.setSecurityLevel(User.securityLevel.ORDINARY);
        user.save();

        // 直接登录
        return loginSrv.loginByPhone(phone, ip);
    }


    public Ret registerByThird(String thirdId, String nickName,
                               int gender,
                               String city,
                               String province,
                               String country,
                               String avatarUrl,

                               int loginType, String ip, boolean sureHasnot) {
        // 判断该手机号是否存在
        if (!sureHasnot && loginSrv.hasAccount(thirdId)) {
            return Fail.setMsg("该账号已存在，请直接登录");
        }


        // 保存用户信息
        User user = new User();
        user.setCreateFrom(loginType);
        user.setSecurityLevel(DANGEROUS);
        user.setThirdId(thirdId);

        user.setAvatarUrl(avatarUrl);
        user.setGender(gender);
        user.setName(nickName);
        user.setRegion(country+"="+province+"-"+city);
        user.setSalt(HashKit.generateSaltForSha256());
        user.setPassword(HashKit.sha256("mixiaomi" + user.getSalt()));


        user.save();

        // 直接登录
        return loginSrv.openIdLogin(thirdId, "",
                nickName,gender,city,province,country,avatarUrl
                , ip);
    }





}

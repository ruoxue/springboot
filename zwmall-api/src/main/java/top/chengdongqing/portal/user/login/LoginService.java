package top.chengdongqing.portal.user.login;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.jfinal.aop.Inject;
import com.jfinal.kit.HashKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.CacheKey;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.User;
import top.chengdongqing.portal.user.register.RegisterService;

/**
 * 登录相关逻辑层
 *
 * @author Luyao
 */
public class LoginService {

    @Inject
    User dao;

    @Inject
    RegisterService registerSrv;

    /**
     * 账号登录
     *
     * @param account
     * @param password
     * @param ip
     * @return
     */
    public Ret accountLogin(String account, String password, String ip) {
        // 查询该账号的盐值
        String sql = "select * from `user` where (phone = #para(0) or email = #para(0)) limit 1";
        User user = dao.templateByString(sql, account).findFirst();
        if (user == null || !user.getPassword().equals(HashKit.sha256(password + user.getSalt()))) {
            return Fail.setMsg("账号或密码错误");
        }
        return handleLoginUser(user, ip);
    }

    /**
     * 手机号加短信验证码登录
     *
     * @param phone
     * @param ip
     * @return
     */
    public Ret captchaLogin(String phone, String ip) {
        if (hasAccount(phone)) {
            // 该账号已注册则直接登录
            return loginByPhone(phone, ip);
        } else {
            // 生成随机密码
            String password = HashKit.generateSalt(12).replaceAll("-", "_");
            // 该账号不存在则直接注册
            return registerSrv.register(phone, password, ip, true);
        }
    }

    /**
     * 根据手机号登录
     *
     * @param phone
     * @param ip
     */
    public Ret loginByPhone(String phone, String ip) {
        String sql = "select * from `user` where phone = ? limit 1";
        User user = dao.findFirst(sql, phone);
        return handleLoginUser(user, ip);
    }

    /**
     * 查询指定的账号是否存在
     *
     * @param account
     * @return
     */
    public boolean hasAccount(String account) {
        String sql = "select id from `user` where phone = #para(0) or email = #para(0) or thirdId=#(0) limit 1";
        return dao.templateByString(sql, account).findFirst() != null;
    }

    /**
     * 处理登录的用户信息
     *
     * @param user
     * @param ip
     * @return
     */
    private Ret handleLoginUser(User user, String ip) {
        if (user == null) {
            return Fail.setMsg("账号或密码错误");
        } else if (user.isDisabled()) {
            return Fail.setMsg("该账号已被冻结");
        }

        // 从缓存的登录信息中清除上次的登录信息
        // CacheKit.remove(CacheKey.LOGIN_USER, user.getToken());

        // 生成token
        String token = StrKit.getRandomUUID();
        // 计算token过期时间
        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        // 更新数据库中的登录信息
        user.setToken(token);
        user.setExpireTime(Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant()));
        user.setLoggedTime(new Date());
        user.setLoggedIp(ip);
        user.update();

        // 仅保留部分用户信息返回给前端
        user.keep("id", "name", "avatarUrl", "gender", "birthday", "region", "motto", "token");
        return Ret.ok("loginUser", user);
    }

    /**
     * 退出登录
     *
     * @param loginUser
     * @return
     */
    public Ret logout(User loginUser) {
        String token = loginUser.getToken();
        loginUser.setToken(null);
        if (loginUser.update()) {
            CacheKit.remove(CacheKey.LOGIN_USER, token);
            return Ret.ok();
        }
        return Ret.fail(Constant.MSG, Fail.Msg.OPERATION_FAIL);
    }

    public Ret openIdLogin(String account, String password,
                           String nickName,
                           int gender,
                           String city,
                           String province,
                           String country,
                           String avatarUrl,

                           String ip) {

        String sql = "select * from `user` where (thirdId = #para(0) or email = #para(0)) limit 1";
        User user = dao.templateByString(sql, account).findFirst();
        if (user != null) {
            return handleLoginUser(user, ip);
        } else {
            return registerSrv.registerByThird(account,
                    nickName,gender,city,province,country,avatarUrl,
                    1, ip, true);
        }


    }
}

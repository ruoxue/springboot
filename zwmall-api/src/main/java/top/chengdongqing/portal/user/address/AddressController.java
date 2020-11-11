package top.chengdongqing.portal.user.address;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.model.UserAddress;
import top.chengdongqing.portal.user.address.validator.AddressSaveValidator;
import top.chengdongqing.portal.user.address.validator.AddressUpdateValidator;

/**
 * 收货地址相关控制器
 * 
 * @author Luyao
 *
 */
public class AddressController extends BaseController {

	@Inject
	AddressService addressSrv;

	/**
	 * 获取指定用户的所有收货地址
	 */
	@Before(GET.class)
	public void index() {
		renderJson(addressSrv.findAll(getUserId()));
	}

	/**
	 * 新增收货地址
	 * 
	 * @param address
	 */
	@Before({ POST.class, AddressSaveValidator.class })
	public void save(@Para("") UserAddress address) {
		renderJson(addressSrv.save(address, getUserId()));
	}

	/**
	 * 更新收货地址
	 * 
	 * @param address
	 */
	@Before({ POST.class, AddressUpdateValidator.class })
	public void update(@Para("") UserAddress address) {
		renderJson(addressSrv.update(address, getUserId()));
	}

	/**
	 * 删除收货地址
	 * 
	 * @param id
	 */
	@NotBlank
	@Before(POST.class)
	public void delete(int id) {
		renderJson(addressSrv.delete(id, getUserId()));
	}
}

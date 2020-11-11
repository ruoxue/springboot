package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAdminPermission<M extends BaseAdminPermission<M>> extends Model<M> implements IBean {

	/**
	 * 接口id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 接口id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 接口名
	 */
	public void setActionKey(java.lang.String actionKey) {
		set("actionKey", actionKey);
	}
	
	/**
	 * 接口名
	 */
	public java.lang.String getActionKey() {
		return getStr("actionKey");
	}

	/**
	 * 该接口所属的控制器
	 */
	public void setController(java.lang.String controller) {
		set("controller", controller);
	}
	
	/**
	 * 该接口所属的控制器
	 */
	public java.lang.String getController() {
		return getStr("controller");
	}

	/**
	 * 接口说明
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 接口说明
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 创建事件
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}
	
	/**
	 * 创建事件
	 */
	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("updateTime", updateTime);
	}
	
	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("updateTime");
	}

}
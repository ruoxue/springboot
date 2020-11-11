package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAdminRoleMenu<M extends BaseAdminRoleMenu<M>> extends Model<M> implements IBean {

	/**
	 * 角色和菜单关联id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 角色和菜单关联id
	 */
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 角色id
	 */
	public void setRoleId(java.lang.Integer roleId) {
		set("roleId", roleId);
	}
	
	/**
	 * 角色id
	 */
	public java.lang.Integer getRoleId() {
		return getInt("roleId");
	}

	/**
	 * 菜单id
	 */
	public void setMenuId(java.lang.Integer menuId) {
		set("menuId", menuId);
	}
	
	/**
	 * 菜单id
	 */
	public java.lang.Integer getMenuId() {
		return getInt("menuId");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}
	
	/**
	 * 创建时间
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
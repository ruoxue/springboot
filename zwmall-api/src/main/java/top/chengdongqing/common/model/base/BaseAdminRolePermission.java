package top.chengdongqing.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAdminRolePermission<M extends BaseAdminRolePermission<M>> extends Model<M> implements IBean {

	/**
	 * 角色和权限关连id
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	/**
	 * 角色和权限关连id
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
	 * 权限id
	 */
	public void setPermissionId(java.lang.Integer permissionId) {
		set("permissionId", permissionId);
	}
	
	/**
	 * 权限id
	 */
	public java.lang.Integer getPermissionId() {
		return getInt("permissionId");
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

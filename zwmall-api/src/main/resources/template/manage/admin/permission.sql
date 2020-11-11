### 查询指定的用户是否有指定的权限
#sql("hasPermission")
	SELECT
		t3.id
	FROM
		admin_user_role t1
	LEFT JOIN admin_role_permission t2 ON t1.roleId = t2.roleId
	LEFT JOIN admin_permission t3 ON t2.permissionId = t3.id
	WHERE
		t1.adminId = #para(0)
	AND t3.actionKey = #para(1)
	LIMIT 1
#end

### 分页查询权限列表
#sql("paginate")
	SELECT
		*
	FROM
		admin_permission
	WHERE
		1 = 1
		
		#if(keyword)
		AND (
			actionKey like concat("%", #para(keyword),"%")
			OR remark like concat("%", #para(keyword),"%")
		)
		#end
		
	ORDER BY
		controller,
		actionKey
#end
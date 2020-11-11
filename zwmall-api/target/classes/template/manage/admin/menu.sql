### 查询指定用户的菜单
#sql("findMenus")
	#if(isSuperAdmin)
		SELECT
			id, `name`
		FROM
			admin_menu
		WHERE
			parentId = 0
		ORDER BY
			sortNo
	#else
		SELECT
			t1.id, t1.name
		FROM
			admin_menu t1
		LEFT JOIN admin_role_menu t2 ON t1.id = t2.menuId
		LEFT JOIN admin_user_role t3 ON t2.roleId = t3.roleId
		WHERE
			t3.adminId = #para(adminId)
			AND parentId = 0
		ORDER BY
			t1.sortNo
	#end
#end

### 查询指定用户的父菜单的子菜单
#sql("findChildrenMenus")
	#if(isSuperAdmin)
		SELECT
			`name`,
			pagePath,
			iconClass
		FROM
			admin_menu
		WHERE
			parentId = #para(parentId)
		ORDER BY
			sortNo
	#else
		SELECT
			t1.name,
			t1.pagePath,
			t1.iconClass
		FROM
			admin_menu t1
		LEFT JOIN admin_role_menu t2 ON t1.id = t2.menuId
		LEFT JOIN admin_user_role t3 ON t2.roleId = t3.roleId
		WHERE
			t3.adminId = #para(adminId)
		AND t1.parentId = #para(parentId)
		ORDER BY
			t1.sortNo
	#end
#end
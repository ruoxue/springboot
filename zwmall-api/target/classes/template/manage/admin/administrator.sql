### 查询管理员列表
#sql("paginate")
	SELECT
		t1.id,
		t2.avatarUrl,
		t2.name,
		t2.phone,
		t3.name role,
		t3.id roleId,
		t1.createTime
	FROM
		admin_user_role t1
	LEFT JOIN `user` t2 ON t1.adminId = t2.id
	LEFT JOIN admin_role t3 ON t1.roleId = t3.id
	WHERE
		1 = 1
		
	#if(roleId != 0)
	AND t1.roleId = #para(roleId)
	#end
		
	#if(keyword)
	AND (
		t2.name LIKE concat("%", #para(keyword), "%")
		OR t2.phone LIKE concat("%", #para(keyword), "%")
	)
	#end
	
	ORDER BY
		t1.createTime
#end
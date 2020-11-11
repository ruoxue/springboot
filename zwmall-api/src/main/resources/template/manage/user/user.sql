### 分页查询用户列表
#sql("paginate")
	SELECT * FROM `user` 
	WHERE 1 = 1
	
	#if(status != -1)
	AND `status` = #para(status)
	#end
	
	#if(keyword)
	AND (
		`name` LIKE concat("%", #para(keyword), "%")
		OR phone LIKE concat("%", #para(keyword), "%")
		OR email LIKE concat("%", #para(keyword), "%")
	)
	#end
	
	ORDER BY createTime DESC
#end

### 注销账户
#sql("cancelAccount")
	DELETE 
	 t1,
	 t2,
	 t3
	FROM
		`user` t1
	LEFT JOIN user_address t2 ON t1.id = t2.userId
	LEFT JOIN user_favorite t3 ON t1.id = t3.userId
	WHERE
		t1.id = #para(0)
#end
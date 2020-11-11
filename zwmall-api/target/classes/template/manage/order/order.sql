### 查询订单列表
#sql("paginate")
	SELECT
		t1.id,
		t1.orderNo,
		t1.status,
		t1.payAmount,
		t1.createTime,
		t2.phone userPhone
	FROM
		`order` t1
	LEFT JOIN `user` t2 ON t1.userId = t2.id
	LEFT JOIN order_address t3 ON t1.orderNo = t3.orderNo
	WHERE
		1 = 1
		
		#if(status != -1)
		AND t1.status = #para(status)
		#end
		#if(startDate && endDate)
		AND (
			t1.createTime > #para(startDate)
			AND t1.createTime < #para(endDate)
		)
		#end
		#if(keyword)
		AND (
			t1.orderNo LIKE concat("%", #para(keyword), "%")
			OR t2.phone LIKE concat("%", #para(keyword), "%")
			OR t3.phone LIKE concat("%", #para(keyword), "%")
		)
		#end
	ORDER BY
		t1.createTime desc
#end
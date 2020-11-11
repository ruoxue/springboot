### 为预付款页面查询订单信息
#sql("baseDetails")
	SELECT
		t1.orderNo,
		t1.status,
		t1.payAmount,
		t1.createTime,
		t2.consignee,
		t2.phone,
		t2.province,
		t2.city,
		t2.district,
		t2.address,
		GROUP_CONCAT(t3.name SEPARATOR '、') goodses
	FROM
		`order` t1
	LEFT JOIN order_address t2 ON t1.orderNo = t2.orderNo
	LEFT JOIN order_goods t3 ON t1.orderNo = t3.orderNo
	WHERE
		t1.orderNo = #para(0)
	AND t1.userId = #para(1)
	GROUP BY 
		t1.id
	LIMIT 1
#end

### 分页查询订单列表
#sql("paginate")
	SELECT
		t1.id,
		t1.orderNo,
		t1.status,
		t1.payAmount,
		t1.payMode,
		t1.createTime,
		t2.consignee
	FROM
		`order` t1
	LEFT JOIN order_address t2 ON t1.orderNo = t2.orderNo
	
	#if(keyword != 'all')
	LEFT JOIN order_goods t3 ON t1.orderNo = t3.orderNo
	#end
	
	WHERE
        1=1
	    #if(goodsId == null || goodsId == 0)
		AND
			(
				t1.userId = #para(userId)
			)
		#end


		
		#if(status != 0)
		AND (
			#switch(status)
				#case(2)
				status >= 2 AND status <= 6
				#case(3)
				status >= 8 AND status <= 10
				#case(4)
				status >= 30 AND status <= 40
				#default
				status = 0
			#end
			)
		#end
		#if(keyword != 'all')
		AND 
			(
				t1.orderNo like concat('%', #para(keyword), '%')
				OR t3.name like concat('%', #para(keyword), '%')
			)
		#end
		#if(goodsId != 'null' && goodsId != 0)
		AND
			(
				t1.goodsId  = #para(goodsId)
			)
		#end
		
	GROUP BY 
		t1.id
	ORDER BY
		t1.createTime DESC
#end

### 删除订单
#sql("delete")
	DELETE t1,
	 t2,
	 t3
	FROM
		`order` t1
	LEFT JOIN order_address t2 ON t1.orderNo = t2.orderNo
	LEFT JOIN order_goods t3 ON t1.orderNo = t3.orderNo
	WHERE
		t1.orderNo = #para(0)
#end
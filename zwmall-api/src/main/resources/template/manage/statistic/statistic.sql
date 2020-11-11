### 查询今日成交金额
#sql("todayAmount")
	select 
		sum(t1.payAmount) amount 
	from 
		`order` t1 left join order_time t2 on t1.orderNo = t2.orderNo
	where 
		(to_days(t2.paidTime) = to_days(curdate()))
	and
		(t1.status >= #para(0) and t1.status <= #para(1))
#end

### 近一年成交金额
#sql("lastYearAmounts")
	select 
		t1.payAmount,
		t2.paidTime
	from 
		`order` t1 left join order_time t2 on t1.orderNo = t2.orderNo
	where 
		t2.paidTime between date_sub(now(), interval 1 year) and now()
	and
		(t1.status >= #para(0) and t1.status <= #para(1))
#end

### 查询商品销售排行榜
#sql("salesRank")
	SELECT
		t2.skuId,
		t2.goodsId,
		sum(t2.count) salesVolume,
		sum(t2.amount) salesAmount
	FROM
		`order` t1
	JOIN order_goods t2 ON t1.orderNo = t2.orderNo
	WHERE 
		t1.status >= #para(0) AND t1.status <= #para(1)
	GROUP BY
		t2.skuId
	ORDER BY
		salesAmount DESC
	LIMIT 100
#end

### 查询品牌销售排行榜
#sql("brandsRank")
	SELECT
		(
			SELECT
				brand.name
			FROM
				goods
			LEFT JOIN goods_brand AS brand ON goods.brandId = brand.id
			WHERE
				goods.id = t2.goodsId
		) brandName,
		sum(t2.amount) salesAmount
	FROM
		`order` t1
	LEFT JOIN order_goods t2 ON t1.orderNo = t2.orderNo
	WHERE 
		(t1.status >= #para(0) AND t1.status <= #para(1))
	GROUP BY
		brandName
	ORDER BY
		salesAmount DESC
	LIMIT 5
#end

### 查询库存紧张的商品
#sql("warningGoodses")
	SELECT
		t1.id,
		t3.urls thumbUrl,
		t1.name,
		t1.skuType,
		t1.status,
		t1.warningStock,
		t2.name skuName,
		t2.stock
	FROM
		goods t1
	LEFT JOIN goods_sku t2 ON t1.id = t2.goodsId
	LEFT JOIN goods_banner t3 ON t2.bannersId = t3.id
	WHERE
		t2.stock <= t1.warningStock
		
		AND t1.status = #para(status)
		#if(keyword)
		AND t1.name LIKE concat("%", #para(keyword), "%")
		#end
		
	ORDER BY t1.createTime DESC
#end
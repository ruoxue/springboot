### 分页查询商品
#sql("paginate")
	SELECT
		t1.id,
		t1.name,
		t1.price,
		t1.thumbUrl,
		t1.status,
		t1.createTime,
		t1.unit,
		t2.name brand,
		t3.name category,
		(
			SELECT
				sum(stock)
			FROM
				goods_sku
			WHERE
				goods_sku.goodsId = t1.id
		) totalStock,
		(
			SELECT
				sum(t4.count)
			FROM
				order_goods t4
			RIGHT JOIN `order` t5 ON t4.orderNo = t5.orderNo
			WHERE
				t4.goodsId = t1.id
			AND (
				t5.status >= #(paidCode)
				AND t5.status <= #(complateCode)
			)
		) totalSales
	FROM
		goods t1
	LEFT JOIN goods_brand t2 ON t1.brandId = t2.id
	LEFT JOIN goods_category t3 ON t1.categoryId = t3.id
	WHERE
		1 = 1 
		
		#if(status != -1)
		AND t1.status = #para(status)
		#end
		#if(keyword)
		AND t1.name LIKE concat("%", #para(keyword), "%")
		#end
		#if(categoryId)
		AND t1.categoryId = #para(categoryId)
		#end
		#if(brandId)
		AND t1.brandId = #para(brandId)
		#end
		
	ORDER BY
		#switch(sortMode)
			#case(1)
			totalSales DESC 
			#case(2)
			totalStock DESC 
			#case(3)
			totalStock ASC
			#case(4)
			t1.price ASC  
			#case(5)
			t1.price DESC 
			#default
			t1.createTime DESC 
		#end
#end
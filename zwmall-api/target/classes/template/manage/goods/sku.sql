### 查询商品的规格信息和每个规格的销量信息
#sql("findSkus")
	SELECT
		goodsAttr,
		price,
		originalPrice,
		costPrice,
		stock,
		(
			SELECT
				sum(t2.count)
			FROM
				order_goods t2
			RIGHT JOIN `order` t3 ON t2.orderNo = t3.orderNo
			WHERE
				t2.skuId = t1.id
			AND (
				t3.status >= #(paidCode)
				AND t3.status <= #(complateCode)
			)
		) sales
	FROM
		goods_sku t1
	WHERE
		goodsId = #para(goodsId)
	ORDER BY
		sortNo
#end
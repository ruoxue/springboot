### 查询所有品牌及下属商品数量
#sql("findBrands")
	SELECT
		id,
		`name`,
		introduction,
		logoUrl,
		createTime,
		(
			SELECT
				count(*)
			FROM
				goods
			WHERE
				brandId = t1.id
		) goodsCount
	FROM
		goods_brand t1
	ORDER BY
		sortNo
#end
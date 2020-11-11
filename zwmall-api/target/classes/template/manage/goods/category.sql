### 查询商品类别及下属商品数量
#sql("findCategories")
	SELECT
		id,
		`name`,
		parentId,
		createTime,
		(
			SELECT
				count(*)
			FROM
				goods
			WHERE
				
				#if(parentId == 0)
					categoryId IN (
						SELECT
							id
						FROM
							goods_category
						WHERE
							parentId = t1.id
					)
				#else
					categoryId = t1.id
				#end
				
		) goodsCount
	FROM
		goods_category t1
	WHERE
		parentId = #para(parentId)
	ORDER BY
		sortNo,
		createTime DESC
#end
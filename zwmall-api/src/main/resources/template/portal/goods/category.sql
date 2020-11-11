#sql("groups")
	SELECT
		group_concat(name SEPARATOR ' ') name,
		group_concat(id) ids,
		(
			SELECT
				sortNo
			FROM
				goods_category
			WHERE
				id = t1.parentId
		) parentSortNo
	FROM
		goods_category t1
	WHERE
		parentId != 0
	GROUP BY
		parentId
	ORDER BY
		parentSortNo,
		sortNo
	LIMIT 10
#end
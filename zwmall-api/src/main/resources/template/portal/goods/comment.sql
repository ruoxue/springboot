#sql("paginate")
	SELECT
		t1.*,
		t2.name userName,
		t2.avatarUrl
	FROM
		goods_comment t1
	LEFT JOIN
		`user` t2
	ON
		t1.userId = t2.id
	WHERE
		t1.goodsId = #para(goodsId)
		AND t1.status = #para(status)
		
		#if(score != 0)
		AND t1.score = #para(score)
		#end
		
		#if(onlyHasPhotos)
		AND t1.photoUrls is not null
		#end
		
	ORDER BY
		t1.createTime DESC
#end
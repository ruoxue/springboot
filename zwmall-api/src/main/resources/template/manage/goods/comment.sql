### 查询评论列表
#sql("paginate")
	select 
		t1.*,
		t2.name goodsName,
		t2.thumbUrl,
		t3.avatarUrl,
		t3.name userName,
		t3.phone userPhone
	from 
		goods_comment t1 left join goods t2 on t1.goodsId = t2.id
		left join `user` t3 on t1.userId = t3.id
	
	where 1 = 1 
	
	#if(score != -1)
	AND score = #(score + 1)
	#end
	#if(goodsId != -1)
	AND t1.goodsId = #para(goodsId)
	#end
	#if(userId != -1)
	AND t1.userId = #para(userId)
	#end
	#if(keyword)
	AND t1.content like concat("%", #para(keyword), "%")
	#end
	
	order by t1.createTime desc
#end
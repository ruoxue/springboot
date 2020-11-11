### 商品搜索
#sql("search")
	SELECT 
		id, `name`, thumbUrl, price, skuType,`type`,
		(
			SELECT
				GROUP_CONCAT(t2.urls)
			FROM 
				goods_sku t1 LEFT JOIN goods_banner t2 on t1.bannersId = t2.id
			WHERE
				t1.goodsId = goods.id
			LIMIT 2
		) AS thumbUrls
		
		#if(sort == "praise" || sort == "sales")
		,(
			SELECT
				avg(score)
			FROM
				#(sort == "praise" ? "goods_comment" : "order_goods")
			WHERE
				goodsId = goods.id
		) AS avgScore
		#end
		
	FROM 
		goods
	WHERE 
		status = #para(status)
		
		#if(keyword && keyword != "all")
		AND `name` LIKE CONCAT("%", #para(keyword), "%")
		#end
		#if(categoryId != -1)
		AND categoryId = #para(categoryId)
		#end
		#if(brandId != -1)
		AND brandId = #para(brandId)
		#end
		
	ORDER BY 
		#switch(sort)
			#case("praise")
			avgScore DESC
			#case("sales")
			avgScore DESC
			#case("price-up")
			price ASC
			#case("price-down")
			price DESC
			#default
			createTime DESC			
		#end
#end

### 商品推荐
#sql("findRecommends")
	SELECT
		id,
		thumbUrl,
		`name`,
		price,
		(
			SELECT
				count(*)
			FROM
				goods_comment
			WHERE
				goodsId = goods.id
			AND score >= 3
		) commentCount
	FROM
		goods
	WHERE
		status = #para(0)
	ORDER BY
		rand()
	LIMIT 10
#end

### 商品规格
#sql("findSkus")
	SELECT
		id,
		goodsAttr,
		price,
		originalPrice,
		stock,
		(
			SELECT
				urls
			FROM
				goods_banner
			WHERE
				id = bannersId
		) bannerUrls
	FROM
		goods_sku
	WHERE
		goodsId = #para(0)
	ORDER BY
		sortNo
#end

### 规格详情
#sql("skuInfo")
	SELECT
		t1.name,
		t1.maxBuy,
		t1.skuType,
		t2.name skuName,
		t2.stock,
		t2.price,
		t2.originalPrice,
		(
			SELECT
				t3.urls
			FROM
				goods_banner t3
			WHERE
				t2.bannersId = t3.id
		) bannerUrls
	FROM
		goods t1
	LEFT JOIN goods_sku t2 ON t1.id = t2.goodsId
	WHERE
		t1.id = #para(0) AND t1.status = #para(1) AND t2.id = #para(2)
	LIMIT 1
#end
### 统一管理所有SQL模板

#namespace("category")
#include("goods/category.sql")
#end

#namespace("goods")
#include("goods/goods.sql")
#end

#namespace("comment")
#include("goods/comment.sql")
#end

#namespace("order")
#include("order/order.sql")
#end
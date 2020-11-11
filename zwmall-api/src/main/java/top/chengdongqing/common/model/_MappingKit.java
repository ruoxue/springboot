package top.chengdongqing.common.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _MappingKit {
	
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("admin_menu", "id", AdminMenu.class);
		arp.addMapping("admin_permission", "id", AdminPermission.class);
		arp.addMapping("admin_role", "id", AdminRole.class);
		arp.addMapping("admin_role_menu", "id", AdminRoleMenu.class);
		arp.addMapping("admin_role_permission", "id", AdminRolePermission.class);
		arp.addMapping("admin_user_role", "id", AdminUserRole.class);
		arp.addMapping("banner", "id", Banner.class);
		arp.addMapping("cart", "id", Cart.class);
		arp.addMapping("goods", "id", Goods.class);
		arp.addMapping("goods_attr_key", "id", GoodsAttrKey.class);
		arp.addMapping("goods_attr_value", "id", GoodsAttrValue.class);
		arp.addMapping("goods_banner", "id", GoodsBanner.class);
		arp.addMapping("goods_brand", "id", GoodsBrand.class);
		arp.addMapping("goods_category", "id", GoodsCategory.class);
		arp.addMapping("goods_comment", "id", GoodsComment.class);
		arp.addMapping("goods_sku", "id", GoodsSku.class);
		arp.addMapping("order", "id", Order.class);
		arp.addMapping("order_address", "id", OrderAddress.class);
		arp.addMapping("order_express", "id", OrderExpress.class);
		arp.addMapping("order_goods", "id", OrderGoods.class);
		arp.addMapping("order_time", "id", OrderTime.class);
		arp.addMapping("user", "id", User.class);
		arp.addMapping("user_address", "id", UserAddress.class);
		arp.addMapping("user_favorite", "id", UserFavorite.class);
		arp.addMapping("video", "id", Video.class);
	}
}


package top.chengdongqing.manage.goods;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jfinal.core.Controller;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.validate.Validator;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.GoodsSku;

/**
 * 商品提交时参数校验
 * 
 * @author Luyao
 *
 */
public class GoodsValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);

		// 商品名称
		validateString("name", 2, 30, Constant.MSG, "请输入正确的商品名称");
		// 商品主图
		validateUrl("thumbUrl", Constant.MSG, "请选择商品主图");
		// 商品价格
		validateDouble("price", 1, 100000, Constant.MSG, "请输入正确的商品售价");
		// 商品类别
		validateInteger("categoryId", Constant.MSG, "请选择商品类别");
		// 商品品牌
		validateInteger("brandId", Constant.MSG, "请选择商品品牌");
		// 商品标题
		validateString("title", 0, 30, Constant.MSG, "商品标题不能超过30个字符");
		// 预警库存
		validateInteger("warningStock", 0, 100000, Constant.MSG, "请输入合理的预警库存");
		// 最大单次可买
		validateInteger("maxBuy", 0, 100, Constant.MSG, "请输入合理的最大单次可买数量");
		// 商品单位
		validateRequired("unit", Constant.MSG, "请选择商品单位");
		// 概述类型
		validateInteger("sketchType", 0, 1, Constant.MSG, "概述类型错误");
		// 商品概述
		Kv details =c.getKv() ;//JSON.parseObject(c.getRawData(), Kv.class);
		if (StrKit.isBlank(details.getStr("sketch"))) {
			addError(Constant.MSG, "请完善商品详情");
		}
		// 规格类型
		validateInteger("skuType", 0, 1, Constant.MSG, "规格类型错误");

		// 轮播图
		if (StrKit.isBlank(details.getStr("banners"))) {
			addError(Constant.MSG, "请选择轮播图");
		}

		// 商品规格
		if (StrKit.isBlank(details.getStr("skus"))) {
			addError(Constant.MSG, "请配置商品规格");
		}
		List<GoodsSku> skus = JSON.parseArray(details.getStr("skus"), GoodsSku.class);
		skus.forEach(sku -> {
			if (StrKit.isBlank(sku.getName())) {
				addError(Constant.MSG, Fail.Msg.PARAM_ERROR);
			}
			if (sku.getBannersId() == null) {
				addError(Constant.MSG, "请为【%s】选择轮播图组".formatted(sku.getName()));
			}
			if (!sku.getStock().toString().matches(GoodsSku.Pattern.NUMBER)) {
				addError(Constant.MSG, "请为【%s】输入正确的数量".formatted(sku.getName()));
			}
			if (!sku.getPrice().toString().matches(GoodsSku.Pattern.PRICE)) {
				addError(Constant.MSG, "请为【%s】输入正确的售价".formatted(sku.getName()));
			}
			if (sku.getOriginalPrice() != null && !sku.getOriginalPrice().toString().matches(GoodsSku.Pattern.PRICE)) {
				addError(Constant.MSG, "请为【%s】输入正确的原价".formatted(sku.getName()));
			}
			if (sku.getCostPrice() != null && !sku.getCostPrice().toString().matches(GoodsSku.Pattern.PRICE)) {
				addError(Constant.MSG, "请为【%s】输入正确的成本价".formatted(sku.getName()));
			}
		});
	}

	@Override
	protected void handleError(Controller c) {
		c.renderJson();
	}
}

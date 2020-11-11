package top.chengdongqing.common.model;

import top.chengdongqing.common.model.base.BaseGoodsSku;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class GoodsSku extends BaseGoodsSku<GoodsSku> {

	/**
	 * 规格相关校验正则
	 */
	public interface Pattern {
		String PRICE = "(?:0\\.\\d{0,1}[1-9]|(?!0)\\d{1,6}(?:\\.\\d{0,1}[1-9])?)";
		String NUMBER = "\\d{1,8}";
	}
}
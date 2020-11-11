package top.chengdongqing.portal.order;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.ext.interceptor.GET;
import com.jfinal.ext.interceptor.POST;

import com.jfinal.kit.Ret;
import top.chengdongqing.common.annotation.NotBlank;
import top.chengdongqing.common.controller.BaseController;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.GoodsSku;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.UserAddress;
import top.chengdongqing.portal.cart.CartService;
import top.chengdongqing.portal.goods.GoodsService;
import top.chengdongqing.portal.order.submit.SubmitService;
import top.chengdongqing.portal.user.address.AddressService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单相关控制器
 *
 * @author Luyao
 */
public class OrderController extends BaseController {

    @Inject
    OrderService orderSrv;
    @Inject
    SubmitService submitSrv;
    @Inject
    AddressService addressSrv;
    @Inject
    CartService cartSrv;
    @Inject
    GoodsService goodsSrv;


    /**
     * 查询订单列表
     */
    @Before(GET.class)
    public void index() {
        int status = getInt("status", 0);
        int type = getInt("type", 0);

        int goodsId = getInt("goodsId", 0);

        String keyword = get("keyword", "all");
        int pageNumber = getInt("pageNumber", 1);
        int pageSize = getInt("pageSize", 10);


        Goods details = goodsSrv.findDetails(goodsId);

        Date startTime = details.getStartTime();


        long l = startTime.getTime() + details.getAuctionTime() * 60 * 1000;


        if (startTime.getTime() < new Date().getTime() && new Date(l).getTime() > new Date().getTime()) {

            renderJson(orderSrv.paginate(status, keyword, goodsId,type,
                    pageNumber, pageSize, getUserId()));
        }else {
            renderJson(Fail.setMsg("拍场未开始或已结束"));
        }


    }

    /**
     *
     */
    @Before(GET.class)
    public void auctionBuy(double price, int goodsId) {

        if (price <= 0) {
            renderJson(Ret.fail("msg", "金额低于当前拍卖价"));
        } else {

            Goods details = goodsSrv.findDetails(goodsId);

            Date startTime = details.getStartTime();
            long l = startTime.getTime() + details.getAuctionTime() * 60 * 1000;


            if (startTime.getTime() > new Date().getTime()
                    || new Date(l).getTime() < new Date().getTime()) {

                    renderJson(Ret.fail("msg", "拍场未开始或已结束"));


            }else {


                if (details != null && details.getPrice() != null
                        && price < details.getPrice().doubleValue()) {
                    renderJson(Ret.fail("msg", "金额低于当前拍卖价"));

                }


                Order preOrder = orderSrv.getMaxOrderByGoodsId(goodsId);

                if (preOrder == null) {
                    Ret skus = goodsSrv.findSkus(goodsId);
                    GoodsSku skus1 = ((List<GoodsSku>) skus.get("skus")).get(0);
                    List<UserAddress> all = addressSrv.findAll(getUserId());

                    renderJson(submitSrv.addAuctionOrder(goodsSrv.findDetails(goodsId),
                            skus1.getId(),
                            BigDecimal.valueOf(price),
                            getUserId(),
                            all.isEmpty() ? null : all.get(0)
                    ));
                } else {
                    if (preOrder.getPayAmount().doubleValue() >= price) {

                        renderJson(Ret.fail("msg", "金额低于当前拍卖价"));//PLsw2iU9xmpfaLCBFnrYnCPl-4E-fHe4Y8
                    } else {
                        List<UserAddress> all = addressSrv.findAll(getUserId());

                        Ret skus = goodsSrv.findSkus(goodsId);
                        GoodsSku skus1 = ((List<GoodsSku>) skus.get("skus")).get(0);
                        renderJson(submitSrv.addAuctionOrder(goodsSrv.findDetails(goodsId),
                                skus1.getId(),
                                BigDecimal.valueOf(price),
                                getUserId(),
                                all.isEmpty() ? null : all.get(0)
                        ));
                    }
                }
            }

        }

    }


    /**
     * 删除订单
     *
     * @param id
     */
    @NotBlank
    @Before(POST.class)
    public void delete(int id) {
        renderJson(orderSrv.delete(id, getUserId()));
    }

    /**
     * 查询订单详情
     *
     * @param orderNo
     */
    @Before(GET.class)
    @NotBlank("orderNo")
    public void details(String orderNo) {
        renderJson(orderSrv.findDetails(orderNo, getUserId()));
    }

    /**
     * 取消订单
     *
     * @param id
     */
    @NotBlank
    @Before(POST.class)
    public void cancel(int id) {
        renderJson(orderSrv.cancelOrder(id, getUserId()));
    }

    /**
     * 申请退款
     *
     * @param id
     */
    @NotBlank
    @Before(POST.class)
    public void refund(int id) {
        renderJson(orderSrv.refundOrder(id, getUserId()));
    }

    /**
     * 确认收货
     *
     * @param id
     */
    @NotBlank
    @Before(POST.class)
    public void confirmReceipt(int id) {
        renderJson(orderSrv.confirmReceipt(id, getUserId()));
    }
}

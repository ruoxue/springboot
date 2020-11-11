package top.chengdongqing.portal.order.submit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.ehcache.CacheKit;

import top.chengdongqing.common.config.Constant;
import top.chengdongqing.common.config.Constant.ConfigFile;
import top.chengdongqing.common.config.Constant.Status;
import top.chengdongqing.common.kit.Fail;
import top.chengdongqing.common.kit.StringKit;
import top.chengdongqing.common.model.Cart;
import top.chengdongqing.common.model.Goods;
import top.chengdongqing.common.model.Order;
import top.chengdongqing.common.model.OrderAddress;
import top.chengdongqing.common.model.OrderGoods;
import top.chengdongqing.common.model.OrderTime;
import top.chengdongqing.common.model.UserAddress;
import top.chengdongqing.portal.cart.CartService;
import top.chengdongqing.portal.goods.GoodsService;
import top.chengdongqing.portal.goods.bo.SkuDetail;

/**
 * 订单提交相关逻辑层
 *
 * @author Luyao
 */
public class SubmitService {

    @Inject
    Order dao;

    @Inject
    CartService cartSrv;

    @Inject
    UserAddress addressDao;

    @Inject
    Goods goodsDao;

    @Inject
    GoodsService goodsSrv;

    @Inject
    OrderTime orderTimeDao;

    private static final Prop prop = PropKit.use(ConfigFile.APPLICATION);

    /**
     * 获取订单邮费
     *
     * @param goodsAmount
     * @return
     */
    public BigDecimal getExpressFee(BigDecimal goodsAmount) {
        // 可免邮的商品金额标准
        Double freeAmount = Double.valueOf(prop.get("freeAmount", "99"));
        // 未达到金额标准需支付的邮费
        BigDecimal expressFee = new BigDecimal(prop.get("expressFee", "10"));
        // 最终邮费
        return goodsAmount.doubleValue() >= freeAmount ? BigDecimal.ZERO : expressFee;
    }

    /**
     * 提交订单处理
     *
     * @param addressId
     * @param userId
     * @return
     */
    public Ret submit(int addressId, int userId) {
        // 查询购物车里选中的商品
        List<Cart> cart = cartSrv.findCart(true, userId);
        if (cart.size() <= 0) {
            return Ret.fail(Constant.MSG, "没有查询到需提交的商品");
        }

        // 查询该收货地址是否存在
        String sqlForAddress = "select * from user_address where id = ? and userId = ? limit 1";
        UserAddress address = addressDao.findFirst(sqlForAddress, addressId, userId);
        if (address == null) {
            return Ret.fail(Constant.MSG, "该收货地址不存在");
        }

        // 获取订单号
        String orderNo = StringKit.generateOrderNo();

        // 同步执行
        synchronized (this) {
            // 保存订单商品详情并计算总金额
            Ret result = saveGoodsItems(cart, orderNo);
            if (result.isFail()) {
                return result;
            }
            BigDecimal goodsAmount = result.getAs("totalAmount");

            // 计算邮费
            BigDecimal expressFee = getExpressFee(goodsAmount);

            // 保存订单并减少商品库存
            boolean createSuccess = createOrder(orderNo, userId, goodsAmount, expressFee, address, cart,1,0);

            // 创建成功返回订单号
            if (createSuccess) {
                return Ret.ok("orderNo", orderNo.toString());
            } else {
                // 创建失败删除所有子订单
                String sqlForDelete = "delete from order_goods where orderNo = ?";
                Db.delete(sqlForDelete);
                return Ret.fail(Constant.MSG, Fail.Msg.SUBMIT_FAIL);
            }
        }
    }

    /**
     * 封装并创建订单
     *
     * @param orderNo
     * @param userId
     * @param goodsAmount
     * @param expressFee
     * @param address
     * @param cart
     * @return
     */
    private boolean createOrder(String orderNo, int userId, BigDecimal goodsAmount, BigDecimal expressFee,
                                UserAddress address, List<Cart> cart,int type,Integer goodsId) {
        // 封装订单
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setGoodsId(goodsId);
        order.setGoodsAmount(goodsAmount);
        order.setType(type);

        order.setExpressFee(expressFee);
        order.setTotalAmount(goodsAmount.add(expressFee));
        order.setDiscountAmount(BigDecimal.ZERO);
        order.setPayAmount(order.getTotalAmount()
                .subtract(order.getDiscountAmount()));

        OrderAddress orderAddress = new OrderAddress();
        // 封装收货地址
        if (address != null) {


            orderAddress.setOrderNo(orderNo);
            orderAddress.setConsignee(address.getName());
            orderAddress.setPhone(address.getPhone());
            orderAddress.setProvince(address.getProvince());
            orderAddress.setCity(address.getCity());
            orderAddress.setDistrict(address.getDistrict());
            orderAddress.setAddress(address.getAddress());
        }
        // 新增订单时间信息
        OrderTime time = new OrderTime();
        time.setOrderNo(orderNo);
        time.setCreateTime(new Date());

        // 保存订单及收货地址
        return Db.tx(() -> {
            // 减少商品库存
            int count = 0;
            String sql = "update goods_sku set stock = stock - ? where id = ? limit 1";
            for (Cart goods : cart) {
                if (Db.update(sql, goods.getCount(), goods.getSkuId()) > 0) {
                    count++;
                    // 清除缓存
                    CacheKit.remove("cart", goods.getSkuId());
                    CacheKit.remove("skus", goods.getId());
                }
            }
            return order.save() && (address!=null?orderAddress.save():true) && time.save() && count == cart.size();
        });
    }

    /**
     * 保存订单商品详情并计算总金额
     *
     * @param cart
     * @param orderNo
     * @return
     */
    private Ret saveGoodsItems(List<Cart> cart, String orderNo) {
        // 总金额
        BigDecimal totalAmount = BigDecimal.ZERO;
        // 已保存数量
        int savedCount = 0;

        for (Cart e : cart) {
            // 判断该商品是否可下单
            Ret result = checkGoods(e);
            if (result.isFail()) {
                return result;
            }

            OrderGoods goods = new OrderGoods();
            goods.setOrderNo(orderNo);
            goods.setGoodsId(e.getGoodsId());
            goods.setSkuId(e.getSkuId());
            goods.setName(e.getName());
            goods.setThumbUrl(e.getThumbUrl());
            goods.setCount(e.getCount());
            goods.setPrice(e.getPrice());
            // 计算小计
            BigDecimal subtotal = e.getPrice().multiply(new BigDecimal(e.getCount().toString()));
            // 四舍五入
            goods.setAmount(subtotal.setScale(2, RoundingMode.HALF_UP));
            if (goods.save()) {
                // 累加总金额
                totalAmount = totalAmount.add(goods.getAmount()).setScale(2, RoundingMode.HALF_UP);
                // 累加成功数量
                savedCount++;
            }
        }

        if (savedCount == cart.size()) {
            return Ret.ok("totalAmount", totalAmount);
        }
        return Ret.fail(Constant.MSG, Fail.Msg.SUBMIT_FAIL);
    }

    /**
     * 判断该商品是否可下单
     *
     * @param
     */
    private Ret checkGoods(Cart e) {
        // 判断该商品的状态
        Goods g = goodsDao.findByIdLoadColumns(e.getGoodsId(), "name, status");
        if (g == null) {
            return Ret.fail(Constant.MSG, e.getName() + " 不存在");
        } else if (g.getStatus() == Status.DISABLED) {
            return Ret.fail(Constant.MSG, g.getName() + " 已下架");
        }

        // 查询规格信息
        SkuDetail sku = goodsSrv.getSkuInfo(e.getGoodsId(), e.getSkuId());
        if (sku == null) {
            return Ret.fail(Constant.MSG, "该商品不存在");
        }

        // 判断该商品的库存
        if (e.getCount() > sku.getStock()) {
            return Ret.fail(Constant.MSG, g.getName() + " 当前库存为：" + sku.getStock());
        }

        // 判断该商品的数量
        if (e.getCount() > sku.getMaxBuy()) {
            return Ret.fail(Constant.MSG, g.getName() + " 单次最大购买量为" + sku.getMaxBuy());
        }
        return Ret.ok();
    }


    public Ret addAuctionOrder(Goods goods, Integer skuId, BigDecimal price, int userId, UserAddress address) {
        // 获取订单号
        String orderNo = StringKit.generateOrderNo();


        // 同步执行
        synchronized (this) {
            // 保存订单商品详情并计算总金额
            Ret result = saveGoodsItems(goods, skuId, price, orderNo);
            if (result.isFail()) {
                return result;
            }
            BigDecimal goodsAmount = result.getAs("totalAmount");

            // 计算邮费
            BigDecimal expressFee = getExpressFee(goodsAmount);


            // 保存订单并减少商品库存
            boolean createSuccess = createOrder(orderNo, userId, goodsAmount, expressFee,
                    address, new ArrayList<>(),2,goods.getId());

            // 创建成功返回订单号
            if (createSuccess) {
                return Ret.ok("orderNo", orderNo.toString());
            } else {
                // 创建失败删除所有子订单
                String sqlForDelete = "delete from order_goods where orderNo = ?";
                Db.delete(sqlForDelete);
                return Ret.fail(Constant.MSG, Fail.Msg.SUBMIT_FAIL);
            }
        }
    }


    /**
     * @param good
     * @param orderNo
     * @param price
     * @return
     */
    private Ret saveGoodsItems(Goods good, Integer skuId, BigDecimal price, String orderNo) {
        // 总金额
        BigDecimal totalAmount = BigDecimal.ZERO;
        // 已保存数量
        int savedCount = 0;


        OrderGoods goods = new OrderGoods();
        goods.setOrderNo(orderNo);
        goods.setGoodsId(good.getId());
        goods.setSkuId(skuId);
        goods.setName(good.getName());
        goods.setThumbUrl(good.getThumbUrl());
        goods.setCount(1);

        goods.setPrice(price);
        goods.setAmount(price);
        // 四舍五入
        if (goods.save()) {

            return Ret.ok("totalAmount", price);
        }
        return null;
    }


}

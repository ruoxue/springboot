package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiOrderPayDao;
import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.service.MiOrderPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiOrderPay)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miOrderPayService")
public class MiOrderPayServiceImpl extends BaseMongoServiceImpl implements MiOrderPayService {
    @Resource
    MiOrderPayDao miOrderPayDao;

    @Override
    public MiOrderPay queryById(String _id) {
        return miOrderPayDao.findById(_id);
    }

    @Override
    public List<MiOrderPay> queryAllByLimit(int offset, int limit) {
        return miOrderPayDao.findAll();
    }

    @Override
    public MiOrderPay insert(MiOrderPay m) {
        return miOrderPayDao.insert(m);
    }

    @Override
    public MiOrderPay update(MiOrderPay m) {
        return miOrderPayDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miOrderPayDao.deleteById(_id);
    }


    @Override
    public void pay(String payId) {
        MiOrderPay orderPay=this.queryById(payId);





    }

    @Override
    public MiOrderPay getByRemark(String out_trade_no) {
        return null;
    }

    @Override
    public boolean orderNotify(String orderId) {
        return false;
    }
}
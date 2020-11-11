package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiOrderDao;
import com.wowotou.model.entity.MiOrder;
import com.wowotou.service.MiOrderService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miOrderService")
public class MiOrderServiceImpl extends BaseMongoServiceImpl implements MiOrderService {
    @Resource
    MiOrderDao miOrderDao;

    @Override
    public MiOrder queryById(String _id) {
        return miOrderDao.findById(_id);
    }

    @Override
    public List<MiOrder> queryAllByLimit(int offset, int limit) {
        return miOrderDao.findAll();
    }

    @Override
    public MiOrder insert(MiOrder m) {
        return miOrderDao.insert(m);
    }

    @Override
    public MiOrder update(MiOrder m) {
        return miOrderDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miOrderDao.deleteById(_id);
    }


    @Override
    public boolean resultSuccess(String out_trade_no, String trade_no, String trade_no1, String userid, String paramStr, String ip) {
        return false;
    }

    @Override
    public MiOrder queryByOrderId(String orderId, String uid) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.and("orderid").is(orderId)
                .and("uid").is(uid);
        query.addCriteria(criteria);
        return miOrderDao.findOne(query);
    }
}
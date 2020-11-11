package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPayAccountDao;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.service.MiPayAccountService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Meta;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPayAccount)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPayAccountService")
public class MiPayAccountServiceImpl  extends BaseMongoServiceImpl  implements MiPayAccountService {
 @Resource
    MiPayAccountDao miPayAccountDao;

    @Override
    public MiPayAccount queryById(String _id) {
        return miPayAccountDao.findById(_id);
    }

    @Override
    public List<MiPayAccount> queryAllByLimit(int offset, int limit) {
        return miPayAccountDao.findAll();
    }

    @Override
    public MiPayAccount insert(MiPayAccount m) {
        return miPayAccountDao.insert(m);
    }

    @Override
    public MiPayAccount update(MiPayAccount m) {
        return miPayAccountDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPayAccountDao.deleteById(_id);
    }

    @Override
    public MiPayAccount queryByUserid(String appId) {
        Query query=new Query();
        Meta meta = new Meta();
        meta.equals(appId);
        query.setMeta(meta);

        return miPayAccountDao.find(query).get(0);
    }

    @Override
    public void updateAccountmTime(String id) {

    }

    @Override
    public MiPayAccount queryByChannelId(String channelId) {
        Query query=new Query();
        Criteria criteria=Criteria.where("channelid").is(channelId);
        query.addCriteria(criteria).with(Sort.by(Sort.Order.asc("mTime")));


        return miPayAccountDao.findOne(query);
    }
}
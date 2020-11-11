package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPayChannelDao;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.service.MiPayChannelService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPayChannel)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPayChannelService")
public class MiPayChannelServiceImpl extends BaseMongoServiceImpl implements MiPayChannelService {
    @Resource
    MiPayChannelDao miPayChannelDao;

    @Override
    public MiPayChannel queryById(String _id) {
        return miPayChannelDao.findById(_id);
    }

    @Override
    public List<MiPayChannel> queryAllByLimit(int offset, int limit) {
        return miPayChannelDao.findAll();
    }

    @Override
    public MiPayChannel insert(MiPayChannel m) {
        return miPayChannelDao.insert(m);
    }

    @Override
    public MiPayChannel update(MiPayChannel m) {
        return miPayChannelDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPayChannelDao.deleteById(_id);
    }

    @Override
    public MiPayChannel queryByType(short type) {
        Query query = new Query();


        return null;
    }

    /**
     * 通过类型id查询
     * @param id
     * @return
     */
    @Override
    public MiPayChannel queryByTypeId(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("typeId").is(id);
        query.addCriteria(criteria);
        return miPayChannelDao.findOne(query);
    }
}
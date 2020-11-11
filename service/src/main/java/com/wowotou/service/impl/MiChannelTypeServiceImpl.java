package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiChannelTypeDao;
import com.wowotou.dao.MiGoodsDao;
import com.wowotou.model.entity.MiChannelType;
import com.wowotou.service.MiChannelTypeService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MiChannelTypeServiceImpl extends  BaseMongoServiceImpl  implements MiChannelTypeService {

    @Resource
    MiChannelTypeDao miChannelTypeDao;
    @Override
    public MiChannelType queryById(String _id) {
        return miChannelTypeDao.findById(_id);
    }

    @Override
    public List<MiChannelType> queryAllByLimit(int offset, int limit) {
        return miChannelTypeDao.findAll();
    }

    @Override
    public MiChannelType insert(MiChannelType m) {
        return miChannelTypeDao.insert(m);
    }

    @Override
    public MiChannelType update(MiChannelType m) {
        return miChannelTypeDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miChannelTypeDao.deleteById(_id);
    }

    @Override
    public MiChannelType queryByType(short type) {
        Query query=new Query();
        Criteria criteria=Criteria.where("type").is(type);
        query.addCriteria(criteria);
        return miChannelTypeDao.findOne(query);
    }
}

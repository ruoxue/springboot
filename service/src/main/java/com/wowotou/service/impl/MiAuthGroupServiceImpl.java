package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAuthGroupDao;
import com.wowotou.model.entity.MiAuthGroup;
import com.wowotou.service.MiAuthGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAuthGroup)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miAuthGroupService")
public class MiAuthGroupServiceImpl extends BaseMongoServiceImpl implements MiAuthGroupService {
 @Resource
    MiAuthGroupDao miAuthGroupDao;

    @Override
    public MiAuthGroup queryById(String _id) {
        return miAuthGroupDao.findById(_id);
    }

    @Override
    public List<MiAuthGroup> queryAllByLimit(int offset, int limit) {
        return miAuthGroupDao.findAll();
    }

    @Override
    public MiAuthGroup insert(MiAuthGroup m) {
        return miAuthGroupDao.insert(m);
    }

    @Override
    public MiAuthGroup update(MiAuthGroup m) {
        return miAuthGroupDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAuthGroupDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiConfigGroupDao;
import com.wowotou.model.entity.MiConfigGroup;
import com.wowotou.service.MiConfigGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiConfigGroup)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miConfigGroupService")
public class MiConfigGroupServiceImpl extends BaseMongoServiceImpl implements MiConfigGroupService {
    @Resource
    MiConfigGroupDao miConfigGroupDao;

    @Override
    public MiConfigGroup queryById(String _id) {
        return miConfigGroupDao.findById(_id);
    }

    @Override
    public List<MiConfigGroup> queryAllByLimit(int offset, int limit) {
        return miConfigGroupDao.findAll();
    }

    @Override
    public MiConfigGroup insert(MiConfigGroup m) {
        return miConfigGroupDao.insert(m);
    }

    @Override
    public MiConfigGroup update(MiConfigGroup m) {
        return miConfigGroupDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miConfigGroupDao.deleteById(_id);
    }
}
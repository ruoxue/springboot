package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiConfigDao;
import com.wowotou.model.entity.MiConfig;
import com.wowotou.service.MiConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiConfig)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miConfigService")
public class MiConfigServiceImpl  extends BaseMongoServiceImpl implements MiConfigService {
@Resource
    MiConfigDao miConfigDao;

    @Override
    public MiConfig queryById(String _id) {
        return miConfigDao.findById(_id);
    }

    @Override
    public List<MiConfig> queryAllByLimit(int offset, int limit) {
        return miConfigDao.findAll();
    }

    @Override
    public MiConfig insert(MiConfig m) {
        return miConfigDao.insert(m);
    }

    @Override
    public MiConfig update(MiConfig m) {
        return miConfigDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miConfigDao.deleteById(_id);
    }
}
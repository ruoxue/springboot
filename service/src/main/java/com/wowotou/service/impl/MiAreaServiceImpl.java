package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAreaDao;
import com.wowotou.model.entity.MiArea;
import com.wowotou.service.MiAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiArea)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAreaService")
public class MiAreaServiceImpl extends BaseMongoServiceImpl implements MiAreaService {
    @Resource
    MiAreaDao miAreaDao;

    @Override
    public MiArea queryById(String _id) {
        return miAreaDao.findById(_id);
    }

    @Override
    public List<MiArea> queryAllByLimit(int offset, int limit) {
        return miAreaDao.findAll();
    }

    @Override
    public MiArea insert(MiArea m) {
        return miAreaDao.insert(m);
    }

    @Override
    public MiArea update(MiArea m) {
        return miAreaDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAreaDao.deleteById(_id);
    }
}
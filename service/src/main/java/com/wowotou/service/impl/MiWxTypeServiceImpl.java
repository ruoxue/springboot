package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxTypeDao;
import com.wowotou.model.entity.MiWxType;
import com.wowotou.service.MiWxTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:51
 */
@Service("miWxTypeService")
public class MiWxTypeServiceImpl extends BaseMongoServiceImpl implements MiWxTypeService {
    @Resource
    MiWxTypeDao miWxTypeDao;

    @Override
    public MiWxType queryById(String _id) {
        return miWxTypeDao.findById(_id);
    }

    @Override
    public List<MiWxType> queryAllByLimit(int offset, int limit) {
        return miWxTypeDao.findAll();
    }

    @Override
    public MiWxType insert(MiWxType m) {
        return miWxTypeDao.insert(m);
    }

    @Override
    public MiWxType update(MiWxType m) {
        return miWxTypeDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxTypeDao.deleteById(_id);
    }
}
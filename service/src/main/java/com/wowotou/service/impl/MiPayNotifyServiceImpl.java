package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPayNotifyDao;
import com.wowotou.model.entity.MiPayNotify;
import com.wowotou.service.MiPayNotifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPayNotify)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPayNotifyService")
public class MiPayNotifyServiceImpl extends BaseMongoServiceImpl implements MiPayNotifyService {
    @Resource
    MiPayNotifyDao miPayNotifyDao;

    @Override
    public MiPayNotify queryById(String _id) {
        return miPayNotifyDao.findById(_id);
    }

    @Override
    public List<MiPayNotify> queryAllByLimit(int offset, int limit) {
        return miPayNotifyDao.findAll();
    }

    @Override
    public MiPayNotify insert(MiPayNotify m) {
        return miPayNotifyDao.insert(m);
    }

    @Override
    public MiPayNotify update(MiPayNotify m) {
        return miPayNotifyDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPayNotifyDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiBankDao;
import com.wowotou.model.entity.MiBank;
import com.wowotou.service.MiBankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiBank)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miBankService")
public class MiBankServiceImpl extends  BaseMongoServiceImpl implements MiBankService {
@Resource
    MiBankDao miBankDao;

    @Override
    public MiBank queryById(String _id) {
        return miBankDao.findById(_id);
    }

    @Override
    public List<MiBank> queryAllByLimit(int offset, int limit) {
        return miBankDao.findAll();
    }

    @Override
    public MiBank insert(MiBank m) {
        return miBankDao.insert(m);
    }

    @Override
    public MiBank update(MiBank m) {
        return miBankDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miBankDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAdvDao;
import com.wowotou.model.entity.MiAdv;
import com.wowotou.service.MiAdvService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAdv)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAdvService")
public class MiAdvServiceImpl extends BaseMongoServiceImpl implements MiAdvService {
     @Resource
    MiAdvDao miAdvDao;

    @Override
    public MiAdv queryById(String _id) {
        return miAdvDao.findById(_id);
    }

    @Override
    public List<MiAdv> queryAllByLimit(int offset, int limit) {
        return miAdvDao.findAll();
    }

    @Override
    public MiAdv insert(MiAdv m) {
        return miAdvDao.insert(m);
    }

    @Override
    public MiAdv update(MiAdv m) {
        return miAdvDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAdvDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAdminDao;
import com.wowotou.model.entity.MiAdmin;
import com.wowotou.service.MiAddressService;
import com.wowotou.service.MiAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAdmin)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAdminService")
public class MiAdminServiceImpl   extends BaseMongoServiceImpl implements MiAdminService {
     @Resource
    MiAdminDao miAdminDao;

    @Override
    public MiAdmin queryById(String _id) {
        return miAdminDao.findById(_id);
    }

    @Override
    public List<MiAdmin> queryAllByLimit(int offset, int limit) {
        return miAdminDao.findAll();
    }

    @Override
    public MiAdmin insert(MiAdmin m) {
        return miAdminDao.insert(m);
    }

    @Override
    public MiAdmin update(MiAdmin m) {
        return miAdminDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAdminDao.deleteById(_id);
    }
}
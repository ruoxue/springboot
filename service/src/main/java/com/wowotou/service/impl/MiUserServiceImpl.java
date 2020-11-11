package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiUserDao;
import com.wowotou.model.entity.MiUser;
import com.wowotou.service.MiUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miUserService")
public class MiUserServiceImpl  extends BaseMongoServiceImpl   implements MiUserService {
 @Resource
    MiUserDao miUserDao;

    @Override
    public MiUser queryById(String _id) {
        return miUserDao.findById(_id);
    }

    @Override
    public List<MiUser> queryAllByLimit(int offset, int limit) {
        return miUserDao.findAll();
    }

    @Override
    public MiUser insert(MiUser m) {
        return miUserDao.insert(m);
    }

    @Override
    public MiUser update(MiUser m) {
        return miUserDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miUserDao.deleteById(_id);
    }
}
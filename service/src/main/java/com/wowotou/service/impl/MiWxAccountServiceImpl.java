package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxAccountDao;
import com.wowotou.model.entity.MiWxAccount;
import com.wowotou.service.MiWxAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxAccount)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miWxAccountService")
public class MiWxAccountServiceImpl extends BaseMongoServiceImpl  implements MiWxAccountService {
 @Resource
    MiWxAccountDao miWxAccountDao;

    @Override
    public MiWxAccount queryById(String _id) {
        return miWxAccountDao.findById(_id);
    }

    @Override
    public List<MiWxAccount> queryAllByLimit(int offset, int limit) {
        return miWxAccountDao.findAll();
    }

    @Override
    public MiWxAccount insert(MiWxAccount m) {
        return null;
    }

    @Override
    public MiWxAccount update(MiWxAccount m) {
        return null;
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
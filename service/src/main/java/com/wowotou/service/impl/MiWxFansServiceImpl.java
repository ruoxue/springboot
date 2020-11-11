package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxFansDao;
import com.wowotou.model.entity.MiWxFans;
import com.wowotou.service.MiWxFansService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxFans)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miWxFansService")
public class MiWxFansServiceImpl extends BaseMongoServiceImpl  implements MiWxFansService {
 @Resource
    MiWxFansDao miWxFansDao;

    @Override
    public MiWxFans queryById(String _id) {
        return miWxFansDao.findById(_id);
    }

    @Override
    public List<MiWxFans> queryAllByLimit(int offset, int limit) {
        return miWxFansDao.findAll();
    }

    @Override
    public MiWxFans insert(MiWxFans m) {
        return miWxFansDao.insert(m);
    }

    @Override
    public MiWxFans update(MiWxFans m) {
        return miWxFansDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxFansDao.deleteById(_id);
    }
}
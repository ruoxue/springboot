package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxTagDao;
import com.wowotou.dao.MiWxTypeDao;
import com.wowotou.model.entity.MiWxTag;
import com.wowotou.service.MiWxTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxTag)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:51
 */
@Service("miWxTagService")
public class MiWxTagServiceImpl extends BaseMongoServiceImpl implements MiWxTagService {
    @Resource
    MiWxTagDao miWxTagDao;

    @Override
    public MiWxTag queryById(String _id) {
        return miWxTagDao.findById(_id);
    }

    @Override
    public List<MiWxTag> queryAllByLimit(int offset, int limit) {
        return miWxTagDao.findAll();
    }

    @Override
    public MiWxTag insert(MiWxTag m) {
        return miWxTagDao.insert(m);
    }

    @Override
    public MiWxTag update(MiWxTag m) {
        return miWxTagDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
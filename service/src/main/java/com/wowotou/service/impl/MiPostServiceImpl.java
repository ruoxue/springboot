package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPostDao;
import com.wowotou.model.entity.MiPost;
import com.wowotou.service.MiPostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPost)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPostService")
public class MiPostServiceImpl extends BaseMongoServiceImpl implements MiPostService {
    @Resource
    MiPostDao miPostDao;

    @Override
    public MiPost queryById(String _id) {
        return miPostDao.findById(_id);
    }

    @Override
    public List<MiPost> queryAllByLimit(int offset, int limit) {
        return miPostDao.findAll();
    }

    @Override
    public MiPost insert(MiPost m) {
        return miPostDao.insert(m);
    }

    @Override
    public MiPost update(MiPost m) {
        return miPostDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPostDao.deleteById(_id);
    }
}
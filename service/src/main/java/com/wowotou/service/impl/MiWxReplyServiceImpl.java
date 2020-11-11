package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxReplyDao;
import com.wowotou.model.entity.MiWxReply;
import com.wowotou.service.MiWxReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxReply)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:49
 */
@Service("miWxReplyService")
public class MiWxReplyServiceImpl extends BaseMongoServiceImpl implements MiWxReplyService {
    @Resource
    MiWxReplyDao miWxReplyDao;

    @Override
    public MiWxReply queryById(String _id) {
        return miWxReplyDao.findById(_id);
    }

    @Override
    public List<MiWxReply> queryAllByLimit(int offset, int limit) {
        return miWxReplyDao.findAll();
    }

    @Override
    public MiWxReply insert(MiWxReply m) {
        return miWxReplyDao.insert(m);
    }

    @Override
    public MiWxReply update(MiWxReply m) {
        return miWxReplyDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxReplyDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPayMissorderDao;
import com.wowotou.model.entity.MiPayMissorder;
import com.wowotou.service.MiPayMissorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPayMissorder)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPayMissorderService")
public class MiPayMissorderServiceImpl  extends BaseMongoServiceImpl  implements MiPayMissorderService {
@Resource
    MiPayMissorderDao miPayMissorderDao;

    @Override
    public MiPayMissorder queryById(String _id) {
        return miPayMissorderDao.findById(_id);
    }

    @Override
    public List<MiPayMissorder> queryAllByLimit(int offset, int limit) {
        return miPayMissorderDao.findAll();
    }

    @Override
    public MiPayMissorder insert(MiPayMissorder m) {
        return miPayMissorderDao.insert(m);
    }

    @Override
    public MiPayMissorder update(MiPayMissorder m) {
        return miPayMissorderDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPayMissorderDao.deleteById(_id);
    }
}
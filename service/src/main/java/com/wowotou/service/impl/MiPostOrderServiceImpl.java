package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiPostOrderDao;
import com.wowotou.model.entity.MiPostOrder;
import com.wowotou.service.MiPostOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiPostOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miPostOrderService")
public class MiPostOrderServiceImpl extends BaseMongoServiceImpl implements MiPostOrderService {
    @Resource
    MiPostOrderDao miPostOrderDao;

    @Override
    public MiPostOrder queryById(String _id) {
        return miPostOrderDao.findById(_id);
    }

    @Override
    public List<MiPostOrder> queryAllByLimit(int offset, int limit) {
        return miPostOrderDao.findAll();
    }

    @Override
    public MiPostOrder insert(MiPostOrder m) {
        return miPostOrderDao.insert(m);
    }

    @Override
    public MiPostOrder update(MiPostOrder m) {
        return miPostOrderDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miPostOrderDao.deleteById(_id);
    }
}
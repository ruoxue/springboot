package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxMsgHistoryDao;
import com.wowotou.model.entity.MiWxMsgHistory;
import com.wowotou.service.MiWxMsgHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxMsgHistory)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:49
 */
@Service("miWxMsgHistoryService")
public class MiWxMsgHistoryServiceImpl  extends BaseMongoServiceImpl  implements MiWxMsgHistoryService {

     @Resource
    MiWxMsgHistoryDao miWxMsgHistoryDao;

    @Override
    public MiWxMsgHistory queryById(String _id) {
        return miWxMsgHistoryDao.findById(_id);
    }

    @Override
    public List<MiWxMsgHistory> queryAllByLimit(int offset, int limit) {
        return miWxMsgHistoryDao.findAll();
    }

    @Override
    public MiWxMsgHistory insert(MiWxMsgHistory m) {
        return miWxMsgHistoryDao.insert(m);
    }

    @Override
    public MiWxMsgHistory update(MiWxMsgHistory m) {
        return miWxMsgHistoryDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxMsgHistoryDao.deleteById(_id);
    }
}
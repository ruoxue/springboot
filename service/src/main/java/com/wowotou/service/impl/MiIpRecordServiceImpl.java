package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiIpRecordDao;
import com.wowotou.model.entity.MiIpRecord;
import com.wowotou.service.MiIpRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiIpRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miIpRecordService")
public class MiIpRecordServiceImpl extends BaseMongoServiceImpl  implements MiIpRecordService {
 @Resource
    MiIpRecordDao miIpRecordDao;

    @Override
    public MiIpRecord queryById(String _id) {
        return miIpRecordDao.findById(_id);
    }

    @Override
    public List<MiIpRecord> queryAllByLimit(int offset, int limit) {
        return miIpRecordDao.findAll();
    }

    @Override
    public MiIpRecord insert(MiIpRecord m) {
        return miIpRecordDao.insert(m);
    }

    @Override
    public MiIpRecord update(MiIpRecord m) {
        return miIpRecordDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miIpRecordDao.deleteById(_id);
    }
}
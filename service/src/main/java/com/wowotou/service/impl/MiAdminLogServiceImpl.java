package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAdminLogDao;
import com.wowotou.model.entity.MiAddress;
import com.wowotou.model.entity.MiAdminLog;
import com.wowotou.service.MiAddressService;
import com.wowotou.service.MiAdminLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAdminLog)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAdminLogService")
public class MiAdminLogServiceImpl  extends BaseMongoServiceImpl implements MiAdminLogService {
 @Resource
    MiAdminLogDao miAdminLogDao;

    @Override
    public MiAdminLog queryById(String _id) {
        return miAdminLogDao.findById(_id);
    }

    @Override
    public List<MiAdminLog> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public MiAdminLog insert(MiAdminLog m) {
        return miAdminLogDao.insert(m);
    }

    @Override
    public MiAdminLog update(MiAdminLog m) {
        return miAdminLogDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAdminLogDao.deleteById(_id);
    }
}
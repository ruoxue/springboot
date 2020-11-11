package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiIpDao;
import com.wowotou.model.entity.MiIp;
import com.wowotou.service.MiIpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiIp)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miIpService")
public class MiIpServiceImpl  extends BaseMongoServiceImpl  implements MiIpService {
 @Resource
    MiIpDao miIpDao;

    @Override
    public MiIp queryById(String _id) {
        return miIpDao.findById(_id);
    }

    @Override
    public List<MiIp> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public MiIp insert(MiIp m) {
        return miIpDao.insert(m);
    }

    @Override
    public MiIp update(MiIp m) {
        return miIpDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miIpDao.deleteById(_id);
    }
}
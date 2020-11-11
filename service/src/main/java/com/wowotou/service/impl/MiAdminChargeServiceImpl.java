package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAdminChargeDao;
import com.wowotou.model.entity.MiAddress;
import com.wowotou.model.entity.MiAdminCharge;
import com.wowotou.service.MiAddressService;
import com.wowotou.service.MiAdminChargeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAdminCharge)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAdminChargeService")
public class MiAdminChargeServiceImpl   extends BaseMongoServiceImpl implements MiAdminChargeService {

    @Resource
    MiAdminChargeDao miAdminChargeDao;

    @Override
    public MiAdminCharge queryById(String _id) {
        return miAdminChargeDao.findById(_id);
    }

    @Override
    public List<MiAdminCharge> queryAllByLimit(int offset, int limit) {
        return miAdminChargeDao.findAll();
    }

    @Override
    public MiAdminCharge insert(MiAdminCharge miAddon) {
        return miAdminChargeDao.insert(miAddon);
    }

    @Override
    public MiAdminCharge update(MiAdminCharge miAddon) {
        return miAdminChargeDao.update(miAddon);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAdminChargeDao.deleteById(_id);
    }
}
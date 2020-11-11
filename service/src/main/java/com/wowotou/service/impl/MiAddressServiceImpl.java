package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAddressDao;
import com.wowotou.model.entity.MiAddress;
import com.wowotou.service.BaseMongoService;
import com.wowotou.service.MiAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAddressService")
public class MiAddressServiceImpl  extends BaseMongoServiceImpl implements MiAddressService {

    @Resource
    MiAddressDao miAddressDao;
    @Override
    public MiAddress queryById(String _id) {
        return miAddressDao.findById(_id);
    }

    @Override
    public List<MiAddress> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public MiAddress insert(MiAddress miAddon) {
        return miAddressDao.insert(miAddon);
    }

    @Override
    public MiAddress update(MiAddress miAddon) {
        return  miAddressDao.update(miAddon);


    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAddressDao.deleteById(_id);
    }
}
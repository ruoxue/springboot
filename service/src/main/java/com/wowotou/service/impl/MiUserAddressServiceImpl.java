package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiUserAddressDao;
import com.wowotou.model.entity.MiUserAddress;
import com.wowotou.service.MiUserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiUserAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miUserAddressService")
public class MiUserAddressServiceImpl  extends BaseMongoServiceImpl  implements MiUserAddressService {
 @Resource
    MiUserAddressDao miUserAddressDao;

    @Override
    public MiUserAddress queryById(String _id) {
        return miUserAddressDao.findById(_id);
    }

    @Override
    public List<MiUserAddress> queryAllByLimit(int offset, int limit) {
        return miUserAddressDao.findAll();
    }

    @Override
    public MiUserAddress insert(MiUserAddress m) {
        return miUserAddressDao.insert(m);
    }

    @Override
    public MiUserAddress update(MiUserAddress m) {
        return miUserAddressDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miUserAddressDao.deleteById(_id);
    }
}
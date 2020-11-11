package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiOauth2ClientDao;
import com.wowotou.model.entity.MiOauth2Client;
import com.wowotou.service.MiOauth2ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiOauth2Client)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miOauth2ClientService")
public class MiOauth2ClientServiceImpl extends BaseMongoServiceImpl  implements MiOauth2ClientService {
 @Resource
    MiOauth2ClientDao miOauth2ClientDao;

    @Override
    public MiOauth2Client queryById(String _id) {
        return miOauth2ClientDao.findById(_id);
    }

    @Override
    public List<MiOauth2Client> queryAllByLimit(int offset, int limit) {
        return miOauth2ClientDao.findAll();
    }

    @Override
    public MiOauth2Client insert(MiOauth2Client m) {
        return miOauth2ClientDao.insert(m);
    }

    @Override
    public MiOauth2Client update(MiOauth2Client m) {
        return miOauth2ClientDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
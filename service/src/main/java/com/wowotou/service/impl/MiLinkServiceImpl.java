package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiLinkDao;
import com.wowotou.model.entity.MiLink;
import com.wowotou.service.MiLinkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiLink)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miLinkService")
public class MiLinkServiceImpl extends BaseMongoServiceImpl  implements MiLinkService {

    @Resource
    MiLinkDao miLinkDao;

    @Override
    public MiLink queryById(String _id) {
        return miLinkDao.findById(_id);
    }

    @Override
    public List<MiLink> queryAllByLimit(int offset, int limit) {
        return miLinkDao.findAll();
    }

    @Override
    public MiLink insert(MiLink miAddon) {
        return miLinkDao.insert(miAddon);
    }

    @Override
    public MiLink update(MiLink miAddon) {
        return miLinkDao.update(miAddon);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miLinkDao.deleteById(_id);
    }
}
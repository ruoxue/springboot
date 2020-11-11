package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiSkuAttrKeyDao;
import com.wowotou.model.entity.MiSkuAttrKey;
import com.wowotou.service.MiSkuAttrKeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiSkuAttrKey)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miSkuAttrKeyService")
public class MiSkuAttrKeyServiceImpl  extends BaseMongoServiceImpl implements MiSkuAttrKeyService {

    @Resource
    MiSkuAttrKeyDao miSkuAttrKeyDao;

    @Override
    public MiSkuAttrKey queryById(String _id) {
        return miSkuAttrKeyDao.findById(_id);
    }

    @Override
    public List<MiSkuAttrKey> queryAllByLimit(int offset, int limit) {
        return miSkuAttrKeyDao.findAll();
    }

    @Override
    public MiSkuAttrKey insert(MiSkuAttrKey m) {
        return miSkuAttrKeyDao.insert(m);
    }

    @Override
    public MiSkuAttrKey update(MiSkuAttrKey m) {
        return miSkuAttrKeyDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miSkuAttrKeyDao.deleteById(_id);
    }
}
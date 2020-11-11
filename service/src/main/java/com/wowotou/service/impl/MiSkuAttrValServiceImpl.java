package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiSkuAttrValDao;
import com.wowotou.model.entity.MiSkuAttrVal;
import com.wowotou.service.MiSkuAttrValService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiSkuAttrVal)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miSkuAttrValService")
public class MiSkuAttrValServiceImpl  extends BaseMongoServiceImpl  implements MiSkuAttrValService {
 @Resource
    MiSkuAttrValDao miSkuAttrValDao;

    @Override
    public MiSkuAttrVal queryById(String _id) {
        return miSkuAttrValDao.findById(_id);
    }

    @Override
    public List<MiSkuAttrVal> queryAllByLimit(int offset, int limit) {
        return miSkuAttrValDao.findAll();
    }

    @Override
    public MiSkuAttrVal insert(MiSkuAttrVal m) {
        return miSkuAttrValDao.insert(m);
    }

    @Override
    public MiSkuAttrVal update(MiSkuAttrVal m) {
        return miSkuAttrValDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miSkuAttrValDao.deleteById(_id);
    }
}
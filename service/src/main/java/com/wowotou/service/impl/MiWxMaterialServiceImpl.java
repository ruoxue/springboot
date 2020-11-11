package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxMaterialDao;
import com.wowotou.model.entity.MiWxMaterial;
import com.wowotou.service.MiWxMaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxMaterial)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miWxMaterialService")
public class MiWxMaterialServiceImpl extends BaseMongoServiceImpl  implements MiWxMaterialService {
 @Resource
    MiWxMaterialDao miWxMaterialDao;

    @Override
    public MiWxMaterial queryById(String _id) {
        return miWxMaterialDao.findById(_id);
    }

    @Override
    public List<MiWxMaterial> queryAllByLimit(int offset, int limit) {
        return miWxMaterialDao.findAll();
    }

    @Override
    public MiWxMaterial insert(MiWxMaterial m) {
        return miWxMaterialDao.insert(m);
    }

    @Override
    public MiWxMaterial update(MiWxMaterial m) {
        return miWxMaterialDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxMaterialDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxMaterialInfoDao;
import com.wowotou.model.entity.MiWxMaterialInfo;
import com.wowotou.service.MiWxMaterialInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxMaterialInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miWxMaterialInfoService")
public class MiWxMaterialInfoServiceImpl extends BaseMongoServiceImpl  implements MiWxMaterialInfoService {
 @Resource
    MiWxMaterialInfoDao miWxMaterialInfoDao;

    @Override
    public MiWxMaterialInfo queryById(String _id) {
        return miWxMaterialInfoDao.findById(_id);
    }

    @Override
    public List<MiWxMaterialInfo> queryAllByLimit(int offset, int limit) {
        return miWxMaterialInfoDao.findAll();
    }

    @Override
    public MiWxMaterialInfo insert(MiWxMaterialInfo m) {
        return miWxMaterialInfoDao.insert(m);
    }

    @Override
    public MiWxMaterialInfo update(MiWxMaterialInfo m) {
        return miWxMaterialInfoDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxMaterialInfoDao.deleteById(_id);
    }
}
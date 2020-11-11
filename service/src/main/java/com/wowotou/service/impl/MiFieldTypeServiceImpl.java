package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiFieldTypeDao;
import com.wowotou.model.entity.MiFieldType;
import com.wowotou.service.MiFieldTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiFieldType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miFieldTypeService")
public class MiFieldTypeServiceImpl extends BaseMongoServiceImpl  implements MiFieldTypeService {
 @Resource
    MiFieldTypeDao miFieldTypeDao;

    @Override
    public MiFieldType queryById(String _id) {
        return miFieldTypeDao.findById(_id);
    }

    @Override
    public List<MiFieldType> queryAllByLimit(int offset, int limit) {
        return miFieldTypeDao.findAll();
    }

    @Override
    public MiFieldType insert(MiFieldType m) {
        return miFieldTypeDao.insert(m);
    }

    @Override
    public MiFieldType update(MiFieldType m) {
        return miFieldTypeDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miFieldTypeDao.deleteById(_id);
    }
}
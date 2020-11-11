package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiGoodsClazzDao;
import com.wowotou.model.entity.MiGoodsClazz;
import com.wowotou.service.MiGoodsClazzService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiGoodsClazz)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miGoodsClazzService")
public class MiGoodsClazzServiceImpl extends BaseMongoServiceImpl  implements MiGoodsClazzService {
@Resource
    MiGoodsClazzDao miGoodsClazzDao;

    @Override
    public MiGoodsClazz queryById(String _id) {
        return miGoodsClazzDao.findById(_id);
    }

    @Override
    public List<MiGoodsClazz> queryAllByLimit(int offset, int limit) {
        return miGoodsClazzDao.findAll();
    }

    @Override
    public MiGoodsClazz insert(MiGoodsClazz m) {
        return miGoodsClazzDao.insert(m);
    }

    @Override
    public MiGoodsClazz update(MiGoodsClazz m) {
        return miGoodsClazzDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
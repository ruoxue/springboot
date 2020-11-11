package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiGoodsSkuTypeDao;
import com.wowotou.model.entity.MiGoodsSkutype;
import com.wowotou.service.MiGoodsSkuTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiGoodsSkuType)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miGoodsSkuTypeService")
public class MiGoodsSkuTypeServiceImpl extends BaseMongoServiceImpl  implements MiGoodsSkuTypeService {
@Resource
    MiGoodsSkuTypeDao miGoodsSkuTypeDao;
    @Override
    public MiGoodsSkutype queryById(String _id) {
        return miGoodsSkuTypeDao.findById(_id);
    }

    @Override
    public List<MiGoodsSkutype> queryAllByLimit(int offset, int limit) {
        return miGoodsSkuTypeDao.findAll();
    }

    @Override
    public MiGoodsSkutype insert(MiGoodsSkutype m) {
        return miGoodsSkuTypeDao.insert(m);
    }

    @Override
    public MiGoodsSkutype update(MiGoodsSkutype m) {
        return miGoodsSkuTypeDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miGoodsSkuTypeDao.deleteById(_id);
    }
}
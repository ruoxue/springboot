package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiGoodsSkuDao;
import com.wowotou.model.entity.MiGoodsSku;
import com.wowotou.service.MiGoodsSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiGoodsSku)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miGoodsSkuService")
public class MiGoodsSkuServiceImpl  extends BaseMongoServiceImpl  implements MiGoodsSkuService {
@Resource
    MiGoodsSkuDao miGoodsSkuDao;
    @Override
    public MiGoodsSku queryById(String _id) {
        return miGoodsSkuDao.findById(_id);
    }

    @Override
    public List<MiGoodsSku> queryAllByLimit(int offset, int limit) {
        return miGoodsSkuDao.findAll();
    }

    @Override
    public MiGoodsSku insert(MiGoodsSku m) {
        return miGoodsSkuDao.insert(m);
    }

    @Override
    public MiGoodsSku update(MiGoodsSku m) {
        return miGoodsSkuDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miGoodsSkuDao.deleteById(_id);
    }
}
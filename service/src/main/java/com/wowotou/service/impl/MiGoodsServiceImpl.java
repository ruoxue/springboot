package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiGoodsDao;
import com.wowotou.model.entity.MiGoods;
import com.wowotou.service.MiGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiGoods)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miGoodsService")
public class MiGoodsServiceImpl extends BaseMongoServiceImpl  implements MiGoodsService {
 @Resource
    MiGoodsDao miGoodsDao;

    @Override
    public MiGoods queryById(String _id) {
        return miGoodsDao.findById(_id);
    }

    @Override
    public List<MiGoods> queryAllByLimit(int offset, int limit) {
        return miGoodsDao.findAll();
    }

    @Override
    public MiGoods insert(MiGoods m) {
        return miGoodsDao.insert(m);
    }

    @Override
    public MiGoods update(MiGoods m) {
        return miGoodsDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miGoodsDao.deleteById(_id);
    }
}
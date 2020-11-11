package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiRegionDao;
import com.wowotou.model.entity.MiRegion;
import com.wowotou.service.MiRegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiRegion)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miRegionService")
public class MiRegionServiceImpl  extends BaseMongoServiceImpl implements MiRegionService {

     @Resource
    MiRegionDao miRegionDao;

    @Override
    public MiRegion queryById(String _id) {
        return miRegionDao.findById(_id);
    }

    @Override
    public List<MiRegion> queryAllByLimit(int offset, int limit) {
        return miRegionDao.findAll();
    }

    @Override
    public MiRegion insert(MiRegion m) {
        return miRegionDao.insert(m);
    }

    @Override
    public MiRegion update(MiRegion m) {
        return miRegionDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miRegionDao.deleteById(_id);
    }
}
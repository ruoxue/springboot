package com.wowotou.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAdvPositionDao;
import com.wowotou.model.entity.MiAdvPosition;
import com.wowotou.service.MiAdvPositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAdvPosition)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAdvPositionService")
public class MiAdvPositionServiceImpl extends BaseMongoServiceImpl implements MiAdvPositionService {

     @Resource
    MiAdvPositionDao miAdvPositionDao;

    @Override
    public MiAdvPosition queryById(String _id) {
        return miAdvPositionDao.findById(_id);
    }

    @Override
    public List<MiAdvPosition> queryAllByLimit(int offset, int limit) {
        return miAdvPositionDao.findAll();
    }

    @Override
    public MiAdvPosition insert(MiAdvPosition m) {
        return miAdvPositionDao.insert(m);
    }

    @Override
    public MiAdvPosition update(MiAdvPosition m) {
        return miAdvPositionDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
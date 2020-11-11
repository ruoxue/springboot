package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiUserLevelDao;
import com.wowotou.model.entity.MiUserLevel;
import com.wowotou.service.MiUserLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiUserLevel)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:48
 */
@Service("miUserLevelService")
public class MiUserLevelServiceImpl extends BaseMongoServiceImpl implements MiUserLevelService {
    @Resource
    MiUserLevelDao miUserLevelDao;

    @Override
    public MiUserLevel queryById(String _id) {
        return miUserLevelDao.findById(_id);
    }

    @Override
    public List<MiUserLevel> queryAllByLimit(int offset, int limit) {
        return miUserLevelDao.findAll();
    }

    @Override
    public MiUserLevel insert(MiUserLevel m) {
        return miUserLevelDao.insert(m);
    }

    @Override
    public MiUserLevel update(MiUserLevel m) {
        return miUserLevelDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miUserLevelDao.deleteById(_id);
    }
}
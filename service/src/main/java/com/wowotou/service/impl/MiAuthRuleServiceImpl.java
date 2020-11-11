package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAuthRuleDao;
import com.wowotou.model.entity.MiAuthRule;
import com.wowotou.service.MiAuthRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAuthRule)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:43
 */
@Service("miAuthRuleService")
public class MiAuthRuleServiceImpl extends BaseMongoServiceImpl implements MiAuthRuleService {
@Resource
    MiAuthRuleDao miAuthRuleDao;

    @Override
    public MiAuthRule queryById(String _id) {
        return miAuthRuleDao.findById(_id);
    }

    @Override
    public List<MiAuthRule> queryAllByLimit(int offset, int limit) {
        return miAuthRuleDao.findAll();
    }

    @Override
    public MiAuthRule insert(MiAuthRule m) {
        return miAuthRuleDao.insert(m);
    }

    @Override
    public MiAuthRule update(MiAuthRule m) {
        return miAuthRuleDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return null;
    }
}
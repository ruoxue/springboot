package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiArticleDao;
import com.wowotou.model.entity.MiArticle;
import com.wowotou.service.MiArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiArticle)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miArticleService")
public class MiArticleServiceImpl extends BaseMongoServiceImpl implements MiArticleService {
    @Resource
    MiArticleDao miArticleDao;

    @Override
    public MiArticle queryById(String _id) {
        return miArticleDao.findById(_id);
    }

    @Override
    public List<MiArticle> queryAllByLimit(int offset, int limit) {
        return miArticleDao.findAll();
    }

    @Override
    public MiArticle insert(MiArticle m) {
        return miArticleDao.insert(m);
    }

    @Override
    public MiArticle update(MiArticle m) {
        return miArticleDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miArticleDao.deleteById(_id);
    }
}
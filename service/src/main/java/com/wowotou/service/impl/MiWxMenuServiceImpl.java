package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxMenuDao;
import com.wowotou.model.entity.MiWxMenu;
import com.wowotou.service.MiWxMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:49
 */
@Service("miWxMenuService")
public class MiWxMenuServiceImpl  extends BaseMongoServiceImpl  implements MiWxMenuService {

@Resource
    MiWxMenuDao miWxMenuDao;
    @Override
    public MiWxMenu queryById(String _id) {
        return miWxMenuDao.findById(_id);
    }

    @Override
    public List<MiWxMenu> queryAllByLimit(int offset, int limit) {
        return miWxMenuDao.findAll();
    }

    @Override
    public MiWxMenu insert(MiWxMenu m) {
        return miWxMenuDao.insert(m);
    }

    @Override
    public MiWxMenu update(MiWxMenu m) {
        return miWxMenuDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxMenuDao.deleteById(_id);
    }
}
package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiWxQrcodeDao;
import com.wowotou.model.entity.MiWxQrcode;
import com.wowotou.service.MiWxQrcodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiWxQrcode)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:49
 */
@Service("miWxQrcodeService")
public class MiWxQrcodeServiceImpl  extends BaseMongoServiceImpl  implements MiWxQrcodeService {

    @Resource
    MiWxQrcodeDao miWxQrcodeDao;

    @Override
    public MiWxQrcode queryById(String _id) {
        return miWxQrcodeDao.findById(_id);
    }

    @Override
    public List<MiWxQrcode> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public MiWxQrcode insert(MiWxQrcode m) {
        return miWxQrcodeDao.insert(m);
    }

    @Override
    public MiWxQrcode update(MiWxQrcode m) {
        return miWxQrcodeDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miWxQrcodeDao.deleteById(_id);
    }
}
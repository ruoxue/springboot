package com.wowotou.service.impl;


import com.mongodb.client.result.DeleteResult;
import com.wowotou.dao.MiAlbumPictureDao;
import com.wowotou.model.entity.MiAlbumPicture;
import com.wowotou.service.MiAlbumPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MiAlbumPicture)表服务实现类
 *
 * @author makejava
 * @since 2020-06-02 00:38:42
 */
@Service("miAlbumPictureService")
public class MiAlbumPictureServiceImpl extends BaseMongoServiceImpl implements MiAlbumPictureService {
    @Resource
    MiAlbumPictureDao miAlbumPictureDao;

    @Override
    public MiAlbumPicture queryById(String _id) {
        return miAlbumPictureDao.findById(_id);
    }

    @Override
    public List<MiAlbumPicture> queryAllByLimit(int offset, int limit) {
        return miAlbumPictureDao.findAll();
    }

    @Override
    public MiAlbumPicture insert(MiAlbumPicture m) {
        return miAlbumPictureDao.insert(m);
    }

    @Override
    public MiAlbumPicture update(MiAlbumPicture m) {
        return miAlbumPictureDao.update(m);
    }

    @Override
    public DeleteResult deleteById(String _id) {
        return miAlbumPictureDao.deleteById(_id);
    }
}
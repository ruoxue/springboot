package com.wowotou.api.controller;

import com.wowotou.model.entity.MiAlbumPicture;
import com.wowotou.service.MiAlbumPictureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAlbumPicture)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAlbumPicture")
public class MiAlbumPictureController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAlbumPictureService miAlbumPictureService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAlbumPicture selectOne(String id) {
        return this.miAlbumPictureService.queryById(id);
    }

}
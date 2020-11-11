package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPost;
import com.wowotou.service.MiPostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPost)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:49
 */
@RestController
@RequestMapping("miPost")
public class MiPostController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPostService miPostService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPost selectOne(String id) {
        return this.miPostService.queryById(id);
    }

}
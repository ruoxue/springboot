package com.wowotou.api.controller;

import com.wowotou.model.entity.MiWxTag;
import com.wowotou.service.MiWxTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxTag)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:03
 */
@RestController
@RequestMapping("miWxTag")
public class MiWxTagController extends  BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MiWxTagService miWxTagService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxTag selectOne(String id) {
        return this.miWxTagService.queryById(id);
    }

}
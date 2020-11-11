package com.wowotou.api.controller;
import com.wowotou.model.entity.MiConfigGroup;
import com.wowotou.service.MiConfigGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiConfigGroup)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miConfigGroup")
public class MiConfigGroupController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiConfigGroupService miConfigGroupService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiConfigGroup selectOne(String id) {
        return this.miConfigGroupService.queryById(id);
    }

}
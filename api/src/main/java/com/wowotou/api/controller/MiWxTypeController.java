package com.wowotou.api.controller;

import com.wowotou.model.entity.MiWxType;
import com.wowotou.service.MiWxTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxType)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:04
 */
@RestController
@RequestMapping("miWxType")
public class MiWxTypeController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxTypeService miWxTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxType selectOne(String id) {
        return this.miWxTypeService.queryById(id);
    }

}
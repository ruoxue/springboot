package com.wowotou.api.controller;

import com.wowotou.model.entity.MiArea;
import com.wowotou.service.MiAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiArea)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miArea")
public class MiAreaController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAreaService miAreaService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiArea selectOne(String id) {
        return this.miAreaService.queryById(id);
    }

}
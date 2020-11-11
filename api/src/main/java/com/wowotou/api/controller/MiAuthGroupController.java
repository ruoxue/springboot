package com.wowotou.api.controller;
import com.wowotou.model.entity.MiAuthGroup;
import com.wowotou.service.MiAuthGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAuthGroup)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAuthGroup")
public class MiAuthGroupController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAuthGroupService miAuthGroupService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAuthGroup selectOne(String id) {
        return this.miAuthGroupService.queryById(id);
    }

}
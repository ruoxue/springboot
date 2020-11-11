package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxMaterial;
import com.wowotou.service.MiWxMaterialService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxMaterial)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:59
 */
@RestController
@RequestMapping("miWxMaterial")
public class MiWxMaterialController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxMaterialService miWxMaterialService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxMaterial selectOne(String id) {
        return this.miWxMaterialService.queryById(id);
    }

}
package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxMaterialInfo;
import com.wowotou.service.MiWxMaterialInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxMaterialInfo)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:00
 */
@RestController
@RequestMapping("miWxMaterialInfo")
public class MiWxMaterialInfoController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxMaterialInfoService miWxMaterialInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxMaterialInfo selectOne(String id) {
        return this.miWxMaterialInfoService.queryById(id);
    }

}
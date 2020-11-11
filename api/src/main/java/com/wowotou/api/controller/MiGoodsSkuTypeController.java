package com.wowotou.api.controller;
import com.wowotou.model.entity.MiGoodsSkutype;
import com.wowotou.service.MiGoodsSkuTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiGoodsSkuType)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:38
 */
@RestController
@RequestMapping("miGoodsSkuType")
public class MiGoodsSkuTypeController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiGoodsSkuTypeService miGoodsSkuTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiGoodsSkutype selectOne(String id) {
        return this.miGoodsSkuTypeService.queryById(id);
    }

}
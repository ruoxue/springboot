package com.wowotou.api.controller;
import com.wowotou.model.entity.MiGoodsSku;
import com.wowotou.service.MiGoodsSkuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiGoodsSku)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:37
 */
@RestController
@RequestMapping("miGoodsSku")
public class MiGoodsSkuController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiGoodsSkuService miGoodsSkuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiGoodsSku selectOne(String id) {
        return this.miGoodsSkuService.queryById(id);
    }

}
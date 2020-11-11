package com.wowotou.api.controller;
import com.wowotou.model.entity.MiGoods;
import com.wowotou.service.MiGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiGoods)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:35
 */
@RestController
@RequestMapping("miGoods")
public class MiGoodsController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiGoodsService miGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiGoods selectOne(String id) {
        return this.miGoodsService.queryById(id);
    }

}
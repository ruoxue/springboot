package com.wowotou.api.controller;
import com.wowotou.model.entity.MiGoodsClazz;
import com.wowotou.service.MiGoodsClazzService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiGoodsClazz)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:36
 */
@RestController
@RequestMapping("miGoodsClazz")
public class MiGoodsClazzController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiGoodsClazzService miGoodsClazzService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiGoodsClazz selectOne(String id) {
        return this.miGoodsClazzService.queryById(id);
    }

}
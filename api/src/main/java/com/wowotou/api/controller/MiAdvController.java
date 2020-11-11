package com.wowotou.api.controller;

import com.wowotou.model.entity.MiAdv;
import com.wowotou.service.MiAdvService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAdv)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAdv")
public class MiAdvController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAdvService miAdvService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAdv selectOne(String id) {
        return this.miAdvService.queryById(id);
    }

}
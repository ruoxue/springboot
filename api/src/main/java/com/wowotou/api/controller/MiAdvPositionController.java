package com.wowotou.api.controller;

import com.wowotou.model.entity.MiAdvPosition;
import com.wowotou.service.MiAdvPositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (MiAdvPosition)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAdvPosition")
public class MiAdvPositionController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAdvPositionService miAdvPositionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAdvPosition selectOne(String id) {
        return this.miAdvPositionService.queryById(id);
    }

}
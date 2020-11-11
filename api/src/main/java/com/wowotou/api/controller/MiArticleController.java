package com.wowotou.api.controller;

import com.wowotou.model.entity.MiArticle;
import com.wowotou.service.MiArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiArticle)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miArticle")
public class MiArticleController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiArticleService miArticleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiArticle selectOne(String id) {
        return this.miArticleService.queryById(id);
    }

}
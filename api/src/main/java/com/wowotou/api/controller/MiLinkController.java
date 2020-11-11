package com.wowotou.api.controller;
import com.wowotou.model.entity.MiLink;
import com.wowotou.service.MiLinkService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiLink)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:42
 */
@RestController
@RequestMapping("miLink")
public class MiLinkController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiLinkService miLinkService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiLink selectOne(String id) {
        return this.miLinkService.queryById(id);
    }

}
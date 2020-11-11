package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxMenu;
import com.wowotou.service.MiWxMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:00
 */
@RestController
@RequestMapping("miWxMenu")
public class MiWxMenuController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxMenuService miWxMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxMenu selectOne(String id) {
        return this.miWxMenuService.queryById(id);
    }

}
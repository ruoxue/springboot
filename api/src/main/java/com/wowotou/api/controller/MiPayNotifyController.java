package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPayNotify;
import com.wowotou.service.MiPayNotifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPayNotify)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:48
 */
@RestController
@RequestMapping("miPayNotify")
public class MiPayNotifyController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPayNotifyService miPayNotifyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPayNotify selectOne(String id) {
        return this.miPayNotifyService.queryById(id);
    }

}
package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxFans;
import com.wowotou.service.MiWxFansService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxFans)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:58
 */
@RestController
@RequestMapping("miWxFans")
public class MiWxFansController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxFansService miWxFansService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxFans selectOne(String id) {
        return this.miWxFansService.queryById(id);
    }

}
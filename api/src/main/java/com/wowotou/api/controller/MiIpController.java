package com.wowotou.api.controller;

import com.wowotou.model.entity.MiIp;
import com.wowotou.service.MiIpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiIp)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:39
 */
@RestController
@RequestMapping("miIp")
public class MiIpController extends  BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MiIpService miIpService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiIp selectOne(String id) {
        return this.miIpService.queryById(id);
    }

}
package com.wowotou.api.controller;
import com.wowotou.model.entity.MiOauth2Client;
import com.wowotou.service.MiOauth2ClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiOauth2Client)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:43
 */
@RestController
@RequestMapping("miOauth2Client")
public class MiOauth2ClientController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiOauth2ClientService miOauth2ClientService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiOauth2Client selectOne(String id) {
        return this.miOauth2ClientService.queryById(id);
    }

}
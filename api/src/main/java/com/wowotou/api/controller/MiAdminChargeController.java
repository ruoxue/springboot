package com.wowotou.api.controller;

import com.wowotou.model.entity.MiAdminCharge;
import com.wowotou.service.MiAdminChargeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAdminCharge)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAdminCharge")
public class MiAdminChargeController extends  BaseController {
    /**
     * 服务对象
     */
    @Resource
    private MiAdminChargeService miAdminChargeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{id}")
    public MiAdminCharge selectOne(String   id) {

        return this.miAdminChargeService.queryById(id);
    }


    @GetMapping("index/{id}")
    public String  selectOne0(String   id) {

        return id;
    }
}
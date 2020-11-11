package com.wowotou.api.controller;

import com.wowotou.model.entity.MiAdminLog;
import com.wowotou.service.MiAdminLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAdminLog)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAdminLog")
public class MiAdminLogController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAdminLogService miAdminLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAdminLog selectOne(String id) {
        return this.miAdminLogService.queryById(id);
    }

}
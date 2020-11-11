package com.wowotou.api.controller;
import com.wowotou.model.entity.MiConfig;
import com.wowotou.service.MiConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiConfig)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miConfig")
public class MiConfigController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiConfigService miConfigService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiConfig selectOne(String id) {
        return this.miConfigService.queryById(id);
    }

}
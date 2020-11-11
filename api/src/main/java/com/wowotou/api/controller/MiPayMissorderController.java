package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPayMissorder;
import com.wowotou.service.MiPayMissorderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPayMissorder)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:47
 */
@RestController
@RequestMapping("miPayMissorder")
public class MiPayMissorderController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPayMissorderService miPayMissorderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPayMissorder selectOne(String id) {
        return this.miPayMissorderService.queryById(id);
    }

}
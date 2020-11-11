package com.wowotou.api.controller;
import com.wowotou.model.entity.MiOrder;
import com.wowotou.service.MiOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiOrder)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:44
 */
@RestController
@RequestMapping("miOrder")
public class MiOrderController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiOrderService miOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiOrder selectOne(String id) {
        return this.miOrderService.queryById(id);
    }

}
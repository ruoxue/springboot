package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPostOrder;
import com.wowotou.service.MiPostOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPostOrder)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:50
 */
@RestController
@RequestMapping("miPostOrder")
public class MiPostOrderController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPostOrderService miPostOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPostOrder selectOne(String id) {
        return this.miPostOrderService.queryById(id);
    }

}
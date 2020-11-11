package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxMsgHistory;
import com.wowotou.service.MiWxMsgHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxMsgHistory)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:01
 */
@RestController
@RequestMapping("miWxMsgHistory")
public class MiWxMsgHistoryController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxMsgHistoryService miWxMsgHistoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxMsgHistory selectOne(String id) {
        return this.miWxMsgHistoryService.queryById(id);
    }

}
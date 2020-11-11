package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.service.MiPayChannelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPayChannel)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:46
 */
@RestController
@RequestMapping("miPayChannel")
public class MiPayChannelController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPayChannelService miPayChannelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPayChannel selectOne(String id) {
        return this.miPayChannelService.queryById(id);
    }

}
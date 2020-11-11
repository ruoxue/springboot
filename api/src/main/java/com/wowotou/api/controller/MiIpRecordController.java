package com.wowotou.api.controller;
import com.wowotou.model.entity.MiIpRecord;
import com.wowotou.service.MiIpRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiIpRecord)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:41
 */
@RestController
@RequestMapping("miIpRecord")
public class MiIpRecordController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiIpRecordService miIpRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiIpRecord selectOne(String id) {
        return this.miIpRecordService.queryById(id);
    }

}
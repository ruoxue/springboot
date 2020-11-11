package com.wowotou.api.controller;
import com.wowotou.model.entity.MiBank;
import com.wowotou.service.MiBankService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiBank)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miBank")
public class MiBankController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiBankService miBankService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiBank selectOne(String id) {
        return this.miBankService.queryById(id);
    }

}
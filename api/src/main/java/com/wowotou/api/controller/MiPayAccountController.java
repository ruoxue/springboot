package com.wowotou.api.controller;
import com.wowotou.model.entity.MiPayAccount;
import com.wowotou.service.MiPayAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiPayAccount)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:45
 */
@RestController
@RequestMapping("miPayAccount")
public class MiPayAccountController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiPayAccountService miPayAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiPayAccount selectOne(String id) {
        return this.miPayAccountService.queryById(id);
    }

}
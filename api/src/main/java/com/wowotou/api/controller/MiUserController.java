package com.wowotou.api.controller;
import com.wowotou.model.entity.MiUser;
import com.wowotou.service.MiUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiUser)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:55
 */
@RestController
@RequestMapping("miUser")
public class MiUserController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiUserService miUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiUser selectOne(String id) {
        return this.miUserService.queryById(id);
    }

}
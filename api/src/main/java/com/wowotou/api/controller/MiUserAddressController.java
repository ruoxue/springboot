package com.wowotou.api.controller;
import com.wowotou.model.entity.MiUserAddress;
import com.wowotou.service.MiUserAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiUserAddress)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:55
 */
@RestController
@RequestMapping("miUserAddress")
public class MiUserAddressController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiUserAddressService miUserAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiUserAddress selectOne(String id) {
        return this.miUserAddressService.queryById(id);
    }

}
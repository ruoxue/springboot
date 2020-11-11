package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxQrcode;
import com.wowotou.service.MiWxQrcodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxQrcode)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:02
 */
@RestController
@RequestMapping("miWxQrcode")
public class MiWxQrcodeController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxQrcodeService miWxQrcodeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxQrcode selectOne(String id) {
        return this.miWxQrcodeService.queryById(id);
    }

}
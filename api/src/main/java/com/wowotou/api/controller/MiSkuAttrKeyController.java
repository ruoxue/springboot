package com.wowotou.api.controller;
import com.wowotou.model.entity.MiSkuAttrKey;
import com.wowotou.service.MiSkuAttrKeyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiSkuAttrKey)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:53
 */
@RestController
@RequestMapping("miSkuAttrKey")
public class MiSkuAttrKeyController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiSkuAttrKeyService miSkuAttrKeyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiSkuAttrKey selectOne(String id) {
        return this.miSkuAttrKeyService.queryById(id);
    }

}
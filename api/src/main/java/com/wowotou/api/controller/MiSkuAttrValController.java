package com.wowotou.api.controller;
import com.wowotou.model.entity.MiSkuAttrVal;
import com.wowotou.service.MiSkuAttrValService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiSkuAttrVal)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:54
 */
@RestController
@RequestMapping("miSkuAttrVal")
public class MiSkuAttrValController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiSkuAttrValService miSkuAttrValService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiSkuAttrVal selectOne(String id) {
        return this.miSkuAttrValService.queryById(id);
    }

}
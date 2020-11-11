package com.wowotou.api.controller;
import com.wowotou.model.entity.MiFieldType;
import com.wowotou.service.MiFieldTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiFieldType)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:33
 */
@RestController
@RequestMapping("miFieldType")
public class MiFieldTypeController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiFieldTypeService miFieldTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiFieldType selectOne(String id) {
        return this.miFieldTypeService.queryById(id);
    }

}
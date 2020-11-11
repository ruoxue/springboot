package com.wowotou.api.controller;
import com.wowotou.model.entity.MiRegion;
import com.wowotou.service.MiRegionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiRegion)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:51
 */
@RestController
@RequestMapping("miRegion")
public class MiRegionController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiRegionService miRegionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiRegion selectOne(String id) {
        return this.miRegionService.queryById(id);
    }

}
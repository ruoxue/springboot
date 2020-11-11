package com.wowotou.api.controller;
import com.wowotou.model.entity.MiAuthRule;
import com.wowotou.service.MiAuthRuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAuthRule)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAuthRule")
public class MiAuthRuleController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAuthRuleService miAuthRuleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAuthRule selectOne(String id) {
        return this.miAuthRuleService.queryById(id);
    }

}
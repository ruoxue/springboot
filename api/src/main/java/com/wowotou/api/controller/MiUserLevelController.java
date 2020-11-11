package com.wowotou.api.controller;
import com.wowotou.model.entity.MiUserLevel;
import com.wowotou.service.MiUserLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiUserLevel)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:57
 */
@RestController
@RequestMapping("miUserLevel")
public class MiUserLevelController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiUserLevelService miUserLevelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiUserLevel selectOne(String id) {
        return this.miUserLevelService.queryById(id);
    }

}
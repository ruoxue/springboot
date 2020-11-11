package com.wowotou.api.controller
;
import com.wowotou.model.entity.MiWxAccount;
import com.wowotou.service.MiWxAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxAccount)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:57
 */
@RestController
@RequestMapping("miWxAccount")
public class MiWxAccountController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxAccountService miWxAccountService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxAccount selectOne(String id) {
        return this.miWxAccountService.queryById(id);
    }

}
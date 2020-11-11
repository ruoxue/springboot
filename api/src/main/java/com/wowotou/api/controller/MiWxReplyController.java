package com.wowotou.api.controller;
import com.wowotou.model.entity.MiWxReply;
import com.wowotou.service.MiWxReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiWxReply)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:13:02
 */
@RestController
@RequestMapping("miWxReply")
public class MiWxReplyController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiWxReplyService miWxReplyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiWxReply selectOne(String id) {
        return this.miWxReplyService.queryById(id);
    }

}
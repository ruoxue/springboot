package  com.wowotou.api.controller;

import com.wowotou.model.entity.MiAdmin;
import com.wowotou.service.MiAdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiAdmin)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:26
 */
@RestController
@RequestMapping("miAdmin")
public class MiAdminController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiAdminService miAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiAdmin selectOne(String id) {
        return this.miAdminService.queryById(id);
    }

}
package  com.wowotou.api.controller;

import com.wowotou.model.entity.MiOrderPay;
import com.wowotou.service.MiOrderPayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MiOrderPay)表控制层
 *
 * @author makejava
 * @since 2020-06-08 22:12:44
 */
@RestController
@RequestMapping("miOrderPay")
public class MiOrderPayController extends  BaseController{
    /**
     * 服务对象
     */
    @Resource
    private MiOrderPayService miOrderPayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MiOrderPay selectOne(String id) {
        return this.miOrderPayService.queryById(id);
    }

}
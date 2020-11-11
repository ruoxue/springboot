package com.wowotou.web;

import com.wowotou.model.entity.ClazzModel;
import com.wowotou.model.entity.MiPayChannel;
import com.wowotou.payservice.order.ALiPayService;
import com.wowotou.payservice.service.ClassService;
import com.wowotou.service.MiPayChannelService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
class WebApplicationTests {

    @Resource
    MiPayChannelService  payChannelService;
    @Test
    void contextLoads() {
//        IOrderService alipay = ServiceFactory.getInstance().getPayService("alipay");
//        System.out.println(alipay);


        List<ClazzModel> sonClass = new ClassService().getSonClass();
        System.out.println(sonClass);

        sonClass.stream().forEach(v->{
            MiPayChannel payChannel=new MiPayChannel();
            payChannel.setApi(v.getServiceName());
            payChannel.setApi2(v.get_id());
            payChannel.setmTime(Instant.now().getEpochSecond());
            payChannel.setcTime(Instant.now().getEpochSecond());
            payChannel.setTitle(v.getName());
            payChannelService.insert(payChannel);
        });


//        miAdmin.addAccount(null);
//        List<MiAdmin> miAdmins = miAdmin.queryAllByLimit(0, 10);
//        System.out.println(miAdmins);
    }

}

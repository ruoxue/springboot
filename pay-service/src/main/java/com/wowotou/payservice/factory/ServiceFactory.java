package com.wowotou.payservice.factory;

import com.wowotou.payservice.SpringContextUtil;
import com.wowotou.payservice.order.IOrderService;

public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }

    private ServiceFactory() {
    }

    public   IOrderService getPayService(String api) {
        IOrderService service = null;
        try {
            service = (IOrderService) SpringContextUtil.getBean(api);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;


    }


    /**
     * 根据传入的api进行反射
     *
     * @param api
     * @return
     */
    public IOrderService createnOrderService(String api) {

        IOrderService service = null;

        try {
            Class<?> aClass = Class.forName(api);

            if (aClass != null) {

                service = (IOrderService) aClass.getDeclaredConstructor().newInstance();

            }

        } catch (Exception e) {

        }

        if (service != null) {
            return service;
        } else {
            System.out.println("调用程序出错");
            return null;
        }
//
//
    }


}

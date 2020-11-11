//package com.wowotou.payservice.hhh;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
//@Component
//@Configuration      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
//public class SaticScheduleTask {
//
//    Logger logger = LoggerFactory.getLogger(SaticScheduleTask.class);
//
//    //2019-04-28 16:38:00.001
//    //3.添加定时任务
//    @Scheduled(cron = "0/31 * * * * ?")
////    或直接指定时间间隔，例如：5秒
////    @Scheduled(fixedRate=5000)
//    private void task1() {
//        startTask(5);
//
//
//    }
//
//    @Resource
//    Query query;
//
////    或直接指定时间间隔，例如：5秒
//    @Scheduled(fixedRate = 10000)
//    private void task2() {
//        startTask(30);
//    }
//
//    private void startTask(int page) {
//        System.err.println("执行静态定时任务时间: " + new Date());
//        logger.info("执行静态定时任务时间: " + new Date());
//        try {
//            query.queryOrder();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        logger.info("结束静态定时任务时间: " + new Date());
//        System.err.println("结束静态定时任务时间: " + new Date());
//
//
//    }
//
//
//    private static boolean isLogin = true;
//
//    @Scheduled(fixedRate = 5000)
//    public void login() {
//        if (isLogin) {
//            isLogin = false;
//           try {
//               query.login();
//           }catch (Exception e){
//               isLogin=true;
//           }
//            isLogin = true;
//        }
//
//    }
//
//   private boolean  isLoginSms=true;
//    @Scheduled(fixedRate = 5000)
//    public void sendLoginSms() {
//        if (isLoginSms) {
//            isLoginSms = false;
//            try {
//                query.sendLoginSms();
//            }catch (Exception e){
//                isLoginSms=true;
//            }
//            isLoginSms = true;
//        }
//
//    }
//
//}
//package com.wowotou.payservice;
//
//
//import com.corundumstudio.socketio.SocketIOServer;
//import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//
//@SpringBootApplication(scanBasePackages = "com.mfypay.*")
////@ServletComponentScan(basePackages = "com.mfypay.*")
//public class PayApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(PayApplication.class, args);
//    }
//
//    @Bean
//    public SocketIOServer socketIOServer() {
//        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
//        config.setHostname("0.0.0.0");
//        config.setPort(6000);
//        final SocketIOServer server = new SocketIOServer(config);
//        return server;
//    }
//
//    @Bean
//    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
//        return new SpringAnnotationScanner(socketServer);
//    }
//
//}

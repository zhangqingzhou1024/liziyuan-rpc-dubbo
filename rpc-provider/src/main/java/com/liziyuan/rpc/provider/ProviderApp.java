package com.liziyuan.rpc.provider;


import com.liziyuan.rpc.provider.api.impl.OrderServiceV1;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpServer;
import com.liziyuan.rpc.provider.framework.register.LocalRegister;

/**
 * @author zqz
 * @date 2024-04-27 13:54
 */
public class ProviderApp {

    public static void main(String[] args) {
        // 用户配置
        // 接收网络请求（Tomcat、Jetty）、Netty、原生ServerSocket
        // 启动 请求接收服务

        // 本地注册
        LocalRegister.register(OrderService.class.getName(), OrderServiceV1.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8090);


    }
}

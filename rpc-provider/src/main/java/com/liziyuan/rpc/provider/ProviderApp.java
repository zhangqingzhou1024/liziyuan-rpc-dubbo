package com.liziyuan.rpc.provider;


import com.liziyuan.rpc.provider.api.impl.OrderServiceV1;
import com.liziyuan.rpc.provider.framework.Protocol;
import com.liziyuan.rpc.provider.framework.ProtocolFactory;
import com.liziyuan.rpc.provider.framework.URL;

/**
 * @author zqz
 * @date 2024-04-27 13:54
 */
public class ProviderApp {

    public static void main(String[] args) {
        // 用户配置
        // 接收网络请求（Tomcat、Jetty）、Netty、原生ServerSocket
        // 启动 请求接收服务

      /*  // 本地注册
        LocalRegister.register(OrderService.class.getName(), OrderServiceV1.class);

        // 注册中心注册
        URL url = new URL("localhost", 8090);
        RemoteMapRegister.regist(OrderService.class.getName(), url);

        *//**
         * 当前是httpserver, 如果用户想用其他
         *//*
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8090);*/


        String protocolName = System.getProperty("protocol");

        URL url = new URL(protocolName, "localhost", 8090, OrderService.class.getName(), OrderServiceV1.class);

        Protocol protocol = ProtocolFactory.getProtocol(protocolName);
        protocol.export(url);


    }
}

package com.liziyuan.rpc.provider.consumer;

import com.liziyuan.rpc.provider.OrderService;
import com.liziyuan.rpc.provider.entity.OrderInfo;
import com.liziyuan.rpc.provider.framework.Invocation;
import com.liziyuan.rpc.provider.framework.ProxyFactory;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpClient;

/**
 * @author zqz
 * @date 2024-04-27 15:29
 */
public class ConsumerApp {

    //OrderService orderService = null;
    public static void main(String[] args) {

        // 封装invocation参数

        Invocation invocation = new Invocation(OrderService.class.getName(), "getOrder",
                new Class[]{String.class}, new Object[]{"zqz222"});

        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8090, invocation);

        // 易用性如何提升? 接口，代理对象， jdk动态代理
        // 更自动的话考虑和spring集成
        OrderService orderService = ProxyFactory.getProxy(OrderService.class);
        OrderInfo orderInfo = orderService.getOrder("zqz");

        System.out.println(result);
        System.out.println(orderInfo);

    }
}

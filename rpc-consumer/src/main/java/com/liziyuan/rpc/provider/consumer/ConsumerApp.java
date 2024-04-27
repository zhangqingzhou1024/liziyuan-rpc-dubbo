package com.liziyuan.rpc.provider.consumer;

import com.liziyuan.rpc.provider.OrderService;
import com.liziyuan.rpc.provider.framework.Invocation;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpClient;

/**
 * @author zqz
 * @date 2024-04-27 15:29
 */
public class ConsumerApp {

    public static void main(String[] args) {

        // 封装invocation参数

        Invocation invocation = new Invocation(OrderService.class.getName(), "getOrder",
                new Class[]{String.class}, new Object[]{"zqz222"});

        HttpClient httpClient = new HttpClient();
        String result = httpClient.send("localhost", 8090, invocation);

        System.out.println(result);

    }
}

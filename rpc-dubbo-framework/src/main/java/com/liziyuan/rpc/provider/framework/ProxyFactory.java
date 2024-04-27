package com.liziyuan.rpc.provider.framework;

import com.alibaba.fastjson.JSON;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zqz
 * @date 2024-04-27 15:46
 */
public class ProxyFactory {


    public static <T> T getProxy(Class interfaceName){

        Object proxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceName}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

                // 封装 invocation
                Invocation invocation = new Invocation(interfaceName.getName(), method.getName(),
                        new Class[]{String.class}, params);

                // 远程调用
                HttpClient httpClient = new HttpClient();
                String result = httpClient.send("localhost", 8090, invocation);


                Object parse = JSON.parseObject(result,  method.getReturnType());
                return parse;
            }
        });

        return (T)proxyInstance;
    }
}

package com.liziyuan.rpc.provider.framework;

import com.alibaba.fastjson.JSON;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpClient;
import com.liziyuan.rpc.provider.framework.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zqz
 * @date 2024-04-27 15:46
 */
public class ProxyFactory {

    /**
     * 本地服务列表，变更会更新
     * <p>
     * redis: 超时、发布订阅
     * zk: 临时节点、watch机制
     */
    private static Map<String, List<URL>> LOCAL_SP_CACHE = new ConcurrentHashMap<>();


    public static <T> T getProxy(Class aClass) {

        Object proxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{aClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {

                // 封装 invocation
                Invocation invocation = new Invocation(aClass.getName(), method.getName(),
                        new Class[]{String.class}, params);

                // 远程调用
                HttpClient httpClient = new HttpClient();

                // 服务提供者的地址？注册中心 zk redis
                // 先查找本地缓存，如果本地缓存没有去注册中心拉取
                List<URL> urls = LOCAL_SP_CACHE.get(aClass.getName());
                if (urls == null) {
                    urls = RemoteMapRegister.getUrls(aClass.getName());
                    LOCAL_SP_CACHE.put(aClass.getName(), urls);
                }


                // 负载均衡 + 重试机制
                URL url = LoadBalance.random(urls);
                String result = httpClient.send(url.getHostName(), url.getPort(), invocation);


                return JSON.parseObject(result, method.getReturnType());
            }
        });

        return (T) proxyInstance;
    }
}

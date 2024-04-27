package com.liziyuan.rpc.provider.framework;

import com.alibaba.fastjson.JSON;

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


    public static <T> T getProxy(Class interfaceClass) {

        Object proxyInstance = Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
                // mock 数据
                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")) {
                    String result = mock.replace("return:", "");
                    return result;
                }

                // 封装 invocation
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(),
                        new Class[]{String.class}, params);

                Invoker invoker = ClusterInvoker.join(interfaceClass);
                String invokeResult = invoker.invoke(invocation);

                return JSON.parseObject(invokeResult, method.getReturnType());
            }
        });

        return (T) proxyInstance;
    }
}

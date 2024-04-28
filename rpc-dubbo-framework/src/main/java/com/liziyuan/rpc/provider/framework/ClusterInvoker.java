package com.liziyuan.rpc.provider.framework;


import com.liziyuan.rpc.provider.framework.register.RemoteMapRegister;

import java.util.ArrayList;
import java.util.List;

public class ClusterInvoker implements Invoker {

    private List<Invoker> invokers = new ArrayList<>();

    public List<Invoker> getInvokers() {
        return invokers;
    }

    public void addInvokers(Invoker invoker) {
        this.invokers.add(invoker);
    }

    public static Invoker join(Class interfaceClass) {
        ClusterInvoker clusterInvoker = new ClusterInvoker();

        // 从注册中心查看urls(有可能不同版本，支持的协议不一样)
        List<URL> urlList = RemoteMapRegister.getUrls(interfaceClass.getName());

        urlList.forEach(url -> {
            Protocol protocol = ProtocolFactory.getProtocol(url.getProtocol());
            Invoker invoker = protocol.refer(url);
            clusterInvoker.addInvokers(invoker);
        });

        return clusterInvoker;
    }

    @Override
    public String invoke(Invocation invocation) {
        Invoker invoker = LoadBalance.random(invokers);
        return invoker.invoke(invocation);
    }
}

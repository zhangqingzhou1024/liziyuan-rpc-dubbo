package com.liziyuan.rpc.provider.framework.protocol.dubbo;


import com.liziyuan.rpc.provider.framework.Invocation;
import com.liziyuan.rpc.provider.framework.Invoker;
import com.liziyuan.rpc.provider.framework.URL;

public class DubboInvoker implements Invoker {

    private URL url;

    public DubboInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(),url.getPort(), invocation);
    }

}

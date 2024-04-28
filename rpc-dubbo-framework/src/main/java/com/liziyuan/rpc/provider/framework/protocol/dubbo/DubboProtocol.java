package com.liziyuan.rpc.provider.framework.protocol.dubbo;


import com.liziyuan.rpc.provider.framework.Invoker;
import com.liziyuan.rpc.provider.framework.Protocol;
import com.liziyuan.rpc.provider.framework.URL;
import com.liziyuan.rpc.provider.framework.register.LocalRegister;
import com.liziyuan.rpc.provider.framework.register.RemoteMapRegister;

public class DubboProtocol implements Protocol {

    @Override
    public void export(URL url) {
        LocalRegister.register(url.getInterfaceName(), url.getImplClass());
        RemoteMapRegister.regist(url.getInterfaceName(), url);
        new NettyServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new DubboInvoker(url);
    }

}

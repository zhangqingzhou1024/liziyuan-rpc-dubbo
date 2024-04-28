package com.liziyuan.rpc.provider.framework.protocol.http;

import com.liziyuan.rpc.provider.framework.Invoker;
import com.liziyuan.rpc.provider.framework.Protocol;
import com.liziyuan.rpc.provider.framework.URL;
import com.liziyuan.rpc.provider.framework.register.LocalRegister;
import com.liziyuan.rpc.provider.framework.register.RemoteMapRegister;

/**
 * @author zqz
 * @date 2024-04-28 0:17
 */
public class HttpProtocol implements Protocol {
    @Override
    public void export(URL url) {
        // 本地注册
        LocalRegister.register(url.getInterfaceName(), url.getImplClass());

        // 注册中心注册
        RemoteMapRegister.regist(url.getInterfaceName(), url);

        /**
         * 当前是httpserver, 如果用户想用其他
         */
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }
}

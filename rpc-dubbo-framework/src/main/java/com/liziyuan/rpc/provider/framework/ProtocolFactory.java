package com.liziyuan.rpc.provider.framework;


import com.liziyuan.rpc.provider.framework.protocol.dubbo.DubboProtocol;
import com.liziyuan.rpc.provider.framework.protocol.http.HttpProtocol;

public class ProtocolFactory {
    public static Protocol getProtocol(String name) {

        if (name == null) {
            return new HttpProtocol();
        }
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }

        return new HttpProtocol();
    }
}

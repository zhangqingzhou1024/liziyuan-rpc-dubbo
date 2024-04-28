package com.liziyuan.rpc.provider.framework.protocol.http;

import com.liziyuan.rpc.provider.framework.Invocation;
import com.liziyuan.rpc.provider.framework.Invoker;
import com.liziyuan.rpc.provider.framework.URL;

/**
 * @author zqz
 * @date 2024-04-28 0:23
 */
public class HttpInvoker implements Invoker {

    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}

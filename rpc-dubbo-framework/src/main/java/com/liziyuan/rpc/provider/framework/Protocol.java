package com.liziyuan.rpc.provider.framework;

import com.liziyuan.rpc.provider.framework.URL;

public interface Protocol {
    /**
     * 服务导出
     * @param url
     */
    void export(URL url);

    /**
     * 服务调用
     * @param url
     * @return
     */
    Invoker refer(URL url);
}

package com.liziyuan.rpc.provider.framework;

import java.io.Serializable;

/**
 * 服务地址
 *
 * @author zqz
 * @date 2024-04-27 22:30
 */
public class URL implements Serializable {

    String hostName;
    Integer port;

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
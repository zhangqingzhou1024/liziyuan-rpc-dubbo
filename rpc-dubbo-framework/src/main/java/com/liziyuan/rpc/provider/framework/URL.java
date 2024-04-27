package com.liziyuan.rpc.provider.framework;

import java.io.Serializable;

/**
 * 服务地址
 *
 * @author zqz
 * @date 2024-04-27 22:30
 */
public class URL implements Serializable {

    private String protocol;
    private String hostname;
    private Integer port;
    private String interfaceName;
    // 此字段不序列化
    private transient Class implClass;

    public URL(String protocol, String hostname, Integer port, String interfaceName, Class implClass) {
        this.protocol = protocol;
        this.hostname = hostname;
        this.port = port;
        this.interfaceName = interfaceName;
        this.implClass = implClass;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Class getImplClass() {
        return implClass;
    }

    public void setImplClass(Class implClass) {
        this.implClass = implClass;
    }
}

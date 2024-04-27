package com.liziyuan.rpc.provider.framework;

import java.io.Serializable;

/**
 * 参数封装
 * 包括先定位
 * 请求参数
 * 提供用户配置：序列化、反序列化
 * JSON、Hession、grpc->protobuf
 *
 * @author zqz
 * @date 2024-04-27 14:59
 */
public class Invocation implements Serializable {

    private String interfaceName;
    private String methodName;
    private Class[] paramType;
    private Object[] params;

    public Invocation() {
    }

    public Invocation(String interfaceName, String methodName, Class[] paramType, Object[] params) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramType = paramType;
        this.params = params;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}

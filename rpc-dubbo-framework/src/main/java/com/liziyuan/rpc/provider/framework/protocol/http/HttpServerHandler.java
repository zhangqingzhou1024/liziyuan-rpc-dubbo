package com.liziyuan.rpc.provider.framework.protocol.http;

import com.alibaba.fastjson.JSON;
import com.liziyuan.rpc.provider.framework.Invocation;
import com.liziyuan.rpc.provider.framework.register.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

/**
 * @author zqz
 * @date 2024-04-27 13:52
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        //获取参数，进行反射调用
        // 参数需要有哪些信息？接口全限定名、方法、入参类型列表 入参列表、
        // 约定 封装参数对象
        // 从接口如何到实现类？

        try {
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();
            // 本地注册表
            Class implClass = LocalRegister.get(invocation.getInterfaceName());

            // 反射执行
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamType());
            Object result = method.invoke(implClass.newInstance(), invocation.getParams());

            // 返回给消费者执行结果
            IOUtils.write(JSON.toJSONString(result), resp.getWriter());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

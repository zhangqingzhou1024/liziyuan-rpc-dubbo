package com.liziyuan.rpc.provider.framework.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * tomcat 请求分发器
 * DispatcherServlet
 *
 * @author zqz
 * @date 2024-04-27 13:25
 */
public class DispatcherServlet extends HttpServlet {

    //ConcurrentHashMap<String, Integer> monitorMap = new ConcurrentHashMap();

    /**
     * 策略模式
     * 处理正常请求
     * 处理统计相关信息
     * 回升测试 类心跳 EchoHandler
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServerHandler().handler(req, resp);
    }
}

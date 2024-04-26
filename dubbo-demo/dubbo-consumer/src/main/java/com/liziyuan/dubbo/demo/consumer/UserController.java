package com.liziyuan.dubbo.demo.consumer;

import com.liziyuan.dubbo.demo.OrderService;
import com.liziyuan.dubbo.demo.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqz
 * @date 2024-04-26 21:41
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    /**
     * check=false,关闭启动时检查，避免当前服务启动时所依赖的提供者不能正常提供服务导致启动失败，生产环境默认true即可，可以及早发现问题所在
     * 同时指定了getOrder方法超时时间为5000毫秒
     */
    @DubboReference(version = "V3", check = false, methods = {@Method(name = "getOrder", timeout = 5000)})
    OrderService orderService;

    @GetMapping("getOrderByUserName")
    public OrderInfo getOrderByUserName(@RequestParam("userName") String userName) {
        // 调用远程服务测试
        OrderInfo orderInfo = orderService.getOrder(userName);
        log.info(">>> dubbo 远程调用成功:{}", orderInfo);
        return orderInfo;
    }
}

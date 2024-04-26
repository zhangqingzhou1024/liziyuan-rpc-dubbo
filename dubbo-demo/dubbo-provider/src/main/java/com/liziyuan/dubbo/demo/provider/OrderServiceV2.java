package com.liziyuan.dubbo.demo.provider;

import com.liziyuan.dubbo.demo.OrderService;
import com.liziyuan.dubbo.demo.entity.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zqz
 * @date 2024-04-26 21:38
 */
@Service // 注，这是spring的注解，不是dubbo的
@DubboService(version = "V2")
@Slf4j
public class OrderServiceV2 implements OrderService {
    @Override
    public OrderInfo getOrder(String userName) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(100L);
        orderInfo.setAmount(new BigDecimal("10000.23"));
        orderInfo.setDate(new Date());
        orderInfo.setUserName(userName+"@V2");
        log.info(">>> provider-serevice V2被调用了...");
        return orderInfo;
    }
}

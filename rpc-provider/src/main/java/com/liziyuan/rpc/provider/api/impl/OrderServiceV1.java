package com.liziyuan.rpc.provider.api.impl;

import com.liziyuan.rpc.provider.OrderService;
import com.liziyuan.rpc.provider.entity.OrderInfo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zqz
 * @date 2024-04-26 21:38
 */

public class OrderServiceV1 implements OrderService {
    public OrderInfo getOrder(String userName) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(100L);
        orderInfo.setAmount(new BigDecimal("10000.23"));
        orderInfo.setDate(new Date());
        orderInfo.setUserName(userName + "@V1");
        // log.info(">>> provider-serevice被调用了...");
        return orderInfo;
    }
}

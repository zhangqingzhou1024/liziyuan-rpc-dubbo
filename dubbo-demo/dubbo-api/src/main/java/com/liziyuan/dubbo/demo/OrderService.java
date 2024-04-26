package com.liziyuan.dubbo.demo;

import com.liziyuan.dubbo.demo.entity.OrderInfo;

/**
 * zqz
 * 订单查询接口定义
 * 公共类
 */
public interface OrderService {

    OrderInfo getOrder(String userName);
}

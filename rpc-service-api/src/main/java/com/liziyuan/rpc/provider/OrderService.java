package com.liziyuan.rpc.provider;


import com.liziyuan.rpc.provider.entity.OrderInfo;

/**
 * zqz
 * 订单查询接口定义
 * 公共类
 */
public interface OrderService {

    OrderInfo getOrder(String userName);
}

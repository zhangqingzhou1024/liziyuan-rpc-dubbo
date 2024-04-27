package com.liziyuan.rpc.provider.framework;

import java.util.List;
import java.util.Random;

/**
 * 负载均衡
 * <p>
 * 随机
 * 轮训
 * ---
 * 加权随机
 * 加权轮训
 * hash
 * 加权平均算法
 *
 * @author zqz
 * @date 2024-04-27 22:40
 */
public class LoadBalance {

    /*public static URL random(List<URL> urlList) {
        // greater than or equal to 0.0 and less than 1.0.
        Random random = new Random();
        return urlList.get(random.nextInt(urlList.size()));
    }*/

    public static Invoker random(List<Invoker> invokers) {
        // greater than or equal to 0.0 and less than 1.0.
        Random random = new Random();
        return invokers.get(random.nextInt(invokers.size()));
    }
}

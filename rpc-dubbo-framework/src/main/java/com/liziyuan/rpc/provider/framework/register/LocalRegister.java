package com.liziyuan.rpc.provider.framework.register;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 从接口到实现类的映射关系
 *
 * @author zqz
 * @date 2024-04-27 15:09
 */
public class LocalRegister {
    private static ConcurrentHashMap<String, Class> map = new ConcurrentHashMap();

    /**
     * 如果是多版本，可把版本参与到key的拼装过程中
     *
     * @param interfaceName 接口名
     * //@param version version
     * @param implCLass 实现类
     */
    public static void register(String interfaceName, Class implCLass) {
        map.put(interfaceName, implCLass);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}

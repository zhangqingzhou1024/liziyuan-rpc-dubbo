package com.liziyuan.rpc.provider.framework.register;

import com.liziyuan.rpc.provider.framework.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟远程注册中心
 *
 * @author zqz
 * @date 2024-04-27 22:27
 */
public class RemoteMapRegister {

    private static Map<String, List<URL>> REGISTER = new ConcurrentHashMap<>();
    private final static String PATH = "./sp_interface_conf.txt";


    public static void regist(String interfaceName, URL url) {
        List<URL> urls = REGISTER.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
        }
        urls.add(url);
        REGISTER.put(interfaceName, urls);

        // 保存到公正地方，redis、zk、mysql等
        saveRemoteSPConfig(REGISTER);
    }

    public static List<URL> getUrls(String interfaceName) {
        REGISTER = getRemoteSPConfig();
        return REGISTER.get(interfaceName);
    }

    private static void saveRemoteSPConfig(Map<String, List<URL>> REGISTER) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(REGISTER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getRemoteSPConfig() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, List<URL>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}

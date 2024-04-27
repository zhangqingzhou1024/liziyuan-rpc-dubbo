package com.liziyuan.rpc.provider.framework.protocol.http;

import com.liziyuan.rpc.provider.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zqz
 * @date 2024-04-27 15:23
 */
public class HttpClient {

    public String send(String hostName, Integer port, Invocation invocation) {

        //这个地方可以进行扩展

        try {
            URL url = new URL("http", hostName, port, "/");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);

            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}


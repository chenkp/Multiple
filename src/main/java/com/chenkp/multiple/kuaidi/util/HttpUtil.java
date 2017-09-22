package com.chenkp.multiple.kuaidi.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet(String urlStr)
    {
        logger.info("发送请求开始，urlStr={}", urlStr);
        String result = "";
        BufferedReader in = null;
        try
        {
            URL url = new URL(urlStr);

            URLConnection connection = url.openConnection();

            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            String key;
            for (Iterator i = map.keySet().iterator(); i.hasNext(); key = (String)i.next()) {}
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result = result + line;
            }
            try {
                if (in != null) {
                    in.close();
                }
            }
            catch (Exception e2) {
                logger.error("httpGet请求出现异常。。。 e2={}",e2);
                e2.printStackTrace();
            }
            logger.info("发送请求成功！result={}", result);
        }
        catch (Exception e) {
            logger.error("发送GET请求出现异常！e={}" + e);
            e.printStackTrace();
        }
        finally {
            try{
                if (in != null) {
                    in.close();
                }
            }
            catch (Exception e2)  {
                logger.error("关闭连接出现异常！e2={}" + e2);
                e2.printStackTrace();
            }
        }
        logger.info("请求快递接口成功！result={}", result);
        return result;
    }
}

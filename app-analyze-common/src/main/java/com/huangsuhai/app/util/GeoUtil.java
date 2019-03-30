package com.huangsuhai.app.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.maxmind.db.Reader;

import java.io.InputStream;
import java.net.InetAddress;

/**
 * 地理工具类，实现通过ip查找地址区域
 */
public class GeoUtil {
    private static InputStream in ;
    private static Reader reader;
    static{
        try {
            //ClassLoader loader = Thread.currentThread().getContextClassLoader();
            //in = loader.getResource("GeoLite2-City.mmdb").openStream();
            in = ClassLoader.getSystemResourceAsStream("GeoLite2-City.mmdb");
            reader = new Reader(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *获得国家数据
     */
    public static String getCountry(String ip){
        try{
            JsonNode node = reader.get(InetAddress.getByName(ip));
            return node.get("country").get("names").get("zh-CN").textValue();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "" ;
    }

    /**
     *获得省份数据
     */
    public static String getProvince(String ip){
        try{
            JsonNode node = reader.get(InetAddress.getByName(ip));
            return node.get("subdivisions").get(0).get("names").get("zh-CN").textValue();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "" ;
    }

    /**
     *获得城市数据
     */
    public static String getCity(String ip){
        try{
            JsonNode node = reader.get(InetAddress.getByName(ip));
            return node.get("city").get("names").get("zh-CN").textValue();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "" ;
    }

}

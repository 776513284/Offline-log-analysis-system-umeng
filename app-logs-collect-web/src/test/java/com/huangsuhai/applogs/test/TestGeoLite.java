package com.huangsuhai.applogs.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.huangsuhai.app.util.GeoUtil;
import com.maxmind.db.Reader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

public class TestGeoLite {
    @Test
    public void test1() throws IOException {
        InputStream in = ClassLoader.getSystemResourceAsStream("GeoLite2-City.mmdb");
        Reader r = new Reader(in);
        JsonNode node = r.get(InetAddress.getByName("14.215.177.39"));
        //国家
        String country = node.get("country").get("names").get("zh-CN").textValue();
        System.out.println(country);
        //省份
        String area = node.get("subdivisions").get(0).get("names").get("zh-CN").textValue();
        //城市
        String city = node.get("city").get("names").get("zh-CN").textValue();

        System.out.println(country + "." + area + "." + city);
    }

    @Test
    public void test2() throws IOException {
        String ip = "123.207.7.47";
        System.out.println(GeoUtil.getCountry(ip) + GeoUtil.getProvince(ip) + GeoUtil.getCity(ip));
    }
}

package com.javaniuniu.shops.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 10:51 AM
 * 全局配置类
 */
//TODO 可省略
@Component
public class AppConfig {
    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader;

    @Value("${user.cookie.name}")
    public String USER_COOKIE_NAME;

    @Value("${user.cookie.age}")
    public int USER_COOKIE_AGE;

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        if (propertiesLoader == null)
            propertiesLoader = new PropertiesLoader("application.properties");
        return propertiesLoader.getProperty(key);
    }

    public static String getAdminPath() {
        return getConfig("adminPath");
    }

    public static String getFrontPath() {
        return getConfig("frontPath");
    }

    public static String getUrlSuffix() {
        return getConfig("urlSuffix");
    }

}

package com.javaniuniu.shops.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/3/1 1:24 PM
 */
//TODO 如何在springboot 处理cookie
public class CookieUtil {
    public static String getCookieValue(HttpServletRequest request, String user_cookie_name) {
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if (user_cookie_name.equals(cookie.getName()))
                    return cookie.getValue();
            }
        }
        return null;
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static void removeCookie(HttpServletResponse response, String name){
        addCookie(response,name,null,0);
    }
}

package com.javaniuniu.shops.util;

import com.javaniuniu.shops.common.Constants;
import com.javaniuniu.shops.model.User;

import javax.servlet.http.HttpSession;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 12:46 PM
 * 用户工具类
 */
public class UserUtil {
    public static final String USER = Constants.LOGIN_USER;

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
        AdminUtil.deleteAdminFromSession(session);
        session.setAttribute(USER, user);
    }

    /**
     * 从Session中删除登陆用户的个人信息
     *
     * @param session
     * @param
     */
    public static void deleteUserFromSession(HttpSession session) {
        session.removeAttribute(USER);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static User getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (User) attribute;
    }
}

package com.javaniuniu.shops.common;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 11:13 AM
 */
//TODO 可改成更壮大
public class Exceptions {
    public static RuntimeException runtimeException(Exception e) {
        return unchecked(e);
    }

    /**
     * 将CheckedException转换为UncheckedException.
     */
    private static RuntimeException unchecked(Exception e) {
        if (e instanceof RuntimeException)
            return (RuntimeException) e;
        else
            return new RuntimeException(e);
    }
}

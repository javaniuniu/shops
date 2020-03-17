package com.javaniuniu.shops.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 12:58 PM
 */
@Setter
@Getter
// TODO 改
public class ResultBase implements Serializable {

    /**
     * 状态
     */
    private Status status;

    /**
     * 消息
     */
    private String message;


    public void setToFail() {
        this.message = "未知异常";
        this.status = Status.FAIL;
    }

    public void setToFail(String message) {
        this.message = message;
        this.status = Status.FAIL;
    }

    public void setToSuccess() {
        this.message = "成功";
        this.status = Status.SUCCESS;
    }

    public void setToSuccess(String message) {
        this.message = message;
        this.status = Status.SUCCESS;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
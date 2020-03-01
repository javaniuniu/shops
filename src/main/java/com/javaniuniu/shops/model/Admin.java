package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 8:38 AM
 * 管理员实体类
 */
@Setter
@Getter
@Entity
@Table(name = "t_admin")
public class Admin extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(16) NOT NULL COMMENT '用户名'")
    private String username;//账户名

    @Column(columnDefinition = "VARCHAR(32) NOT NULL COMMENT '密码'")
    private String password;//密码

}
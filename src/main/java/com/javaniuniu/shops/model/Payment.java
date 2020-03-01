package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 9:16 AM
 */
@Setter
@Getter
@Entity
@Table(name = "t_payment")
public class Payment extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(20) NOT NULL COMMENT '付款人名字'")
    private String name;
}

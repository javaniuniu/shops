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
 * @Date: 2020/2/27 10:58 AM
 * 普通分类
 */
@Setter
@Getter
@Entity
@Table(name = "t_producttype")
public class ProductType extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(32) NOT NULL COMMENT '分类名称'")
    private String name;

}


package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 10:58 AM
 * 用于cookie
 */
@Setter
@Getter
@Entity
@Table(name = "t_remember")
public class Remember extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private User user;

}
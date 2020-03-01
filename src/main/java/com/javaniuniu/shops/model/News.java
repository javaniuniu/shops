package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 8:39 AM
 * 新闻
 */
@Setter
@Getter
@Entity
@Table(name = "t_news")
public class News extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(64) NOT NULL COMMENT '标题'")
    private String title;

    @Column(columnDefinition = "VARCHAR(512) NOT NULL COMMENT '内容'")
    private String content;

    @ManyToOne //多篇新闻对于一个管理员
    @JoinColumn(columnDefinition = "COMMENT '管理员'")
    private Admin inputUser;

}
package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 9:17 AM
 */
@Setter
@Getter
@Entity
@DynamicUpdate
@Table(name = "t_picture")
public class Picture extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(32) NOT NULL COMMENT '图片名称'")
    private String title;

    @Column(columnDefinition = "VARCHAR(128) NOT NULL COMMENT '图片描述'")
    private String memo;

    @Column(columnDefinition = "VARCHAR(64) NOT NULL COMMENT '图片地址'")
    private String url;

    @ManyToOne
    @JoinColumn
    private Admin updateAdmin;
}

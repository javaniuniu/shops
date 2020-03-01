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
 * 公告
 */
@Entity
@Setter
@Getter
@Table(name = "t_announcement")
public class Announcement extends AbstractEntity {

    @Column(columnDefinition = "VARCHAR(512) NOT NULL COMMENT '公告内容'")
    private String content;

    @ManyToOne //多个公告对于一个管理员
    @JoinColumn(columnDefinition = "BIGINT(20) NOT NULL COMMENT '创建管理员ID'")
    //JoinColumn 不添加name属性，按照生成数据库字段的规则_id
    private Admin createAdmin;

}
package com.javaniuniu.shops.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 9:03 AM
 * 订单关联明细
 */
@Setter
@Getter
//@DynamicUpdate
//@DynamicInsert
@Entity
@Table(name = "t_orderitem")
public class OrderItem extends AbstractEntity {

    @OneToOne
    private Product product;

    @ManyToOne //多个订单明细关联一个订单列表
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(columnDefinition = "INT(11) NOT NULL COMMENT '订单数量'")
    private Integer quantity;

//    @UpdateTimestamp
//    @Column(name = "update_time", columnDefinition = "datetime")
//    private Timestamp updateTime;
//
//    @CreationTimestamp
//    @Column(name = "create_time", columnDefinition = "datetime",  updatable = false)
//    private Timestamp createTime;
}

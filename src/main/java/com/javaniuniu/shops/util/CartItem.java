package com.javaniuniu.shops.util;

import com.javaniuniu.shops.model.Product;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/29 4:43 PM
 * 购物车关联项
 */
public class CartItem {
    private Product product;//商品
    private Integer total;//数量

    public CartItem(Product product, Integer total) {
        this.product = product;
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
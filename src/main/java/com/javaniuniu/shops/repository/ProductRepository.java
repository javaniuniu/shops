package com.javaniuniu.shops.repository;

import com.javaniuniu.shops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 11:09 AM
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByOrderByCreateTimeDesc();

    List<Product> findByOrderByCreateTimeAsc();

    @Query("FROM Product p")
    List<Product> findPopProducts();

}

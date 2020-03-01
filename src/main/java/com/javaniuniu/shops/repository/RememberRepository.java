package com.javaniuniu.shops.repository;

import com.javaniuniu.shops.model.Remember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 11:10 AM
 */
@Repository
public interface RememberRepository extends JpaRepository<Remember, String> {
}


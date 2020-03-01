package com.javaniuniu.shops.repository;

import com.javaniuniu.shops.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 11:00 AM
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin findByUsernameAndPassword(String username, String password);
}

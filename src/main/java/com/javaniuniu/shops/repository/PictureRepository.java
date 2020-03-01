package com.javaniuniu.shops.repository;

import com.javaniuniu.shops.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 11:09 AM
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}


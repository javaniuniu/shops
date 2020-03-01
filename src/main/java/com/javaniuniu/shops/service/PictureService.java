package com.javaniuniu.shops.service;


import com.javaniuniu.shops.model.Picture;
import com.javaniuniu.shops.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:32 PM
 */
@Service
@Transactional
public class PictureService {

    @Autowired
    PictureRepository pictureDao;

    public void save(Picture picture) {
        pictureDao.save(picture);
    }

    public List<Picture> findAll() {
        return pictureDao.findAll();
    }

}
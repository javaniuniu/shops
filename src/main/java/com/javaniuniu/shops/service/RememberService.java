package com.javaniuniu.shops.service;

import com.javaniuniu.shops.model.Remember;
import com.javaniuniu.shops.repository.RememberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:32 PM
 */
@Service
public class RememberService {

    @Autowired
    RememberRepository rememberRepository;

    public void add(Remember remember) {
        rememberRepository.save(remember);
    }

    public void delete(String uuid) {
        rememberRepository.deleteById(uuid);
    }

    public Remember findById(String uuid) {
        return rememberRepository.getOne(uuid);
    }
}
package com.javaniuniu.shops.service;


import com.javaniuniu.shops.model.Admin;
import com.javaniuniu.shops.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/minplemon
 * @Date: 2020/2/27 7:32 PM
 */
@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminDao;

    public boolean checkLogin(Admin admin) {
        return findByUsernameAndPassword(admin.getUsername(), admin.getPassword()) == null ? false : true;
    }

    public Admin findByUsernameAndPassword(String username, String password) {
        return adminDao.findByUsernameAndPassword(username, password);
    }

    public void save(Admin admin) {
        adminDao.save(admin);
    }

    public Admin findOne(Integer id) {
        return adminDao.getOne(id);
    }

}
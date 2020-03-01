package com.javaniuniu.shops.service;

import com.javaniuniu.shops.model.User;
import com.javaniuniu.shops.repository.UserRepository;
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
public class UserService {

	@Autowired
	private UserRepository userDao;

	public boolean checkLogin(User user) {
		user = userDao.findByUsernameAndPassword(user.getUsername(),
				user.getPassword());
		return user != null;
	}
	
	public User findByUsernameAndPassword(String username,String password){
		User user = userDao.findByUsernameAndPassword(username, password);
		return user;
	}

    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }
	
	public void save(User user) {
		userDao.save(user);
	}

	public User findOne(Integer id) {
		return userDao.getOne(id);
	}

}
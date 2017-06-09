package com.kripesh.salesapp.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kripesh.salesapp.dao.UserDao;
import com.kripesh.salesapp.model.User;
import com.kripesh.salesapp.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByUserId(Long userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	public User save(User user) {
		List<User> userList = findAll();
		for(User u : userList){
			if(u.getUserName().equals(user.getUserName()) || u.getUserName() == user.getUserName()){
				return new User();
			}
		}
		return userDao.save(user);
	}
	
	@Override
	public User update(User user) {
		return userDao.save(user);
		
	}

}

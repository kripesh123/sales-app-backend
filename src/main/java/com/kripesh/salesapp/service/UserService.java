package com.kripesh.salesapp.service;

import java.util.List;

import com.kripesh.salesapp.model.User;

public interface UserService {
	
	List<User> findAll();

	User findByUserName(String userName);

	User findByUserId(Long userId);

	User save(User user);
	
	User update(User user);
}

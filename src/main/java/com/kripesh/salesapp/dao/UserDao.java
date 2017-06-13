package com.kripesh.salesapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kripesh.salesapp.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
	List<User> findAll();

	User findByUserName(String userName);

	User findByUserId(Long userId);

	User save(User user);
	
	List<User> 	findByFirstNameLikeOrLastNameLikeOrUserNameLike(String firstName, String lastName, String userName);
}

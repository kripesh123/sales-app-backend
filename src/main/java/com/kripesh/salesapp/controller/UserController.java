package com.kripesh.salesapp.controller;


import static com.kripesh.salesapp.controller.utils.ApiConstant.API_VER;
import static com.kripesh.salesapp.controller.utils.ApiConstant.USER_PATH;
import static com.kripesh.salesapp.controller.utils.ApiConstant.FIRSTNAME_PARAM;
import static com.kripesh.salesapp.controller.utils.ApiConstant.LASTNAME_PARAM;
import static com.kripesh.salesapp.controller.utils.ApiConstant.USERNAME_PARAM;
import static com.kripesh.salesapp.controller.utils.ApiConstant.ACTION_SEARCH_USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kripesh.salesapp.model.User;
import com.kripesh.salesapp.service.UserService;

@RestController
@RequestMapping(API_VER + USER_PATH)
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>>  getAllUser(){	
		List<User> userList=userService.findAll();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@RequestMapping(value="user",method = RequestMethod.GET)
	public ResponseEntity<User>  getByUserId(@RequestParam(value ="userId", required = true) long userId){
		User user=userService.findByUserId(userId);
		if(user != null){
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(user,HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="users",method = RequestMethod.GET)
	public ResponseEntity<User>  getByUserId(@RequestParam(value ="userName", required = true) String userName){
		User user=userService.findByUserName(userName);
		if(user != null){
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value="users",method= RequestMethod.GET,params={FIRSTNAME_PARAM,LASTNAME_PARAM,USERNAME_PARAM,ACTION_SEARCH_USER})
	public ResponseEntity<List<User>> searchUser(@RequestParam String action,@RequestParam String firstName,@RequestParam String lastName,@RequestParam String userName){
		
		List<User> userList = userService.findByFirstNameLikeAndLastNameAndUserName(firstName, lastName, userName);
		if(userList.isEmpty() || userList == null){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
         userService.save(user);
         return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
         User updatedUser=userService.update(user);
         return new ResponseEntity<User>(updatedUser,HttpStatus.CREATED);
    }
}

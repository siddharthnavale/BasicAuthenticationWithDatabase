package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;

@Service
public class UserService {
	
	List <User> userList= new ArrayList<>();
	
	public UserService() {
		User user1 = new User(1,"Siddhart","abc","sidnavale@gmail.com");
		User user2 = new User(2,"Varun","abc","varun@gmail.com");
		
		userList.add(user1);
		userList.add(user2);
	}
	
	public List <User> getAllUser(){

		return this.userList;
		
	}
	
	public User getUserById(int UserId){

		for(User user:userList) {
			if(user.getUserId()==UserId) {
			return	user;
			}
		}
		return null;
	}
	
	
	public String addUser(User user) {
		
		this.userList.add(user);
		return "User details added successfully";
		
	}
	
}

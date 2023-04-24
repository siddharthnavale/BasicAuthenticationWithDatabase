package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/")
	public List<User> getAllUser() {

		return userservice.getAllUser();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {

		return userservice.getUserById(userId);
	}

	@PostMapping("/")
	public String addUser(@RequestBody User user) {

		return userservice.addUser(user);
	}
}

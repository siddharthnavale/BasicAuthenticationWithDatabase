package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

@SpringBootApplication
public class BasicAuthenticationSpringSecurityWithDatabaseApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BasicAuthenticationSpringSecurityWithDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1= new User();
		user1.setUserName("Siddharth");
		user1.setUserId(1);
		user1.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user1.setEmail("sid@gmail.com");
		user1.setRole("ROLE_NORMAL");
		userRepository.save(user1);
		
		User user2= new User();
		user2.setUserId(2);
		user2.setUserName("Mudassir");
		user2.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user2.setEmail("mudassir@gmail.com");
		user2.setRole("ROLE_ADMIN");
		userRepository.save(user2);
		
		
		
		
	}

}

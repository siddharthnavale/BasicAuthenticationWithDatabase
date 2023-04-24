package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
public class User {
	
@Id
	private int userId;
	private String userName;
	private String Password;
	private String email;
	private String role;
	
	public User() {
		
	}
	
	public User(int userId, String userName, String password, String email, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		Password = password;
		this.email = email;
		this.role = role;
	}

	public User(int userId, String userName, String password, String email) {
	
		this.userId = userId;
		this.userName = userName;
		Password = password;
		this.email = email;
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	


}

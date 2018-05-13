package com.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

	@Id
	private long id;
	
	private String username;
	
	private String loginname;
	
	private String password;
	
	private String email;

	private String role;
	
	public User() {
		
	}
	
	public User(String username, String loginname, String password, String email, String role) {
		super();
		this.username = username;
		this.loginname = loginname;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginname=" + loginname + ", password=" + password
				+ ", email=" + email + ", role=" + role + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

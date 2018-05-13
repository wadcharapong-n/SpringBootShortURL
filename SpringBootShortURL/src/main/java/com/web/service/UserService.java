package com.web.service;

import com.web.model.User;



public interface UserService {
	
	public User findById(long id);
	
	public User findByName(String name);
	
	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public boolean isUserExist(User user);
	
}

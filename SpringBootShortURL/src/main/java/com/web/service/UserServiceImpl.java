package com.web.service;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.web.ConnectionDB;
import com.web.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	public User findById(long id) {

		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("id").is(id));

		// find
		User userDB = ConnectionDB.getConnection().findOne(searchShortUrlQuery, User.class);

		return userDB;
	}

	public User findByName(String name) {
		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("loginname").is(name));

		// find
		User userDB = ConnectionDB.getConnection().findOne(searchShortUrlQuery, User.class);

		return userDB;
	}

	public void saveUser(User user) {
		ConnectionDB.getConnection().save(user);
	}

	public void updateUser(User user) {
		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("id").is(user.getId()));

		// find
		// User userDB = ConnectionDB.getConnection().findOne(searchShortUrlQuery,
		// User.class);

		// update
		ConnectionDB.getConnection().updateFirst(searchShortUrlQuery, Update.update("password", user.getPassword()),
				User.class);
	}

	public boolean isUserExist(User user) {
		// query to search
		Query searchShortUrlQuery = new Query(Criteria.where("loginname").is(user.getLoginname()));

		// find
		User userDB = ConnectionDB.getConnection().findOne(searchShortUrlQuery, User.class);
		
		return userDB == null ? true:false;
	}

}

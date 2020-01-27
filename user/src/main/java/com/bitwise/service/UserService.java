package com.bitwise.service;

import com.bitwise.Dao.UserDao;
import com.bitwise.Data.User;

public class UserService {

	public boolean userModification(User user) {

		String name = "Mr." + user.getName();
		user.setName(name);
		return new UserDao().insertUser(user);

	}

}

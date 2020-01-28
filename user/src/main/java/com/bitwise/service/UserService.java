package com.bitwise.service;

import com.bitwise.Dao.UserDao;
import com.bitwise.Data.User;

public class UserService {

	public boolean userModification(User user) {

		user.setName("Mr." + user.getName());
		return new UserDao().insertUser(user);

	}

}

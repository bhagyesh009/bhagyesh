package com.bitwise.service;

import com.bitwise.Dao.UserDao;
import com.bitwise.Data.User;

public class UserService {

	public boolean userModification(User user) {

		user.setName("Mr." + user.getName());
		return new UserDao().insertUser(user);

	}

	public boolean userDeletion(int id) {
		return new UserDao().deleteUser(id);

	}

	public User userDetail(int id) {

		return new UserDao().getUser(id);

	}

	public boolean userUpdate(int id, long mobNo) {

		return new UserDao().updateUser(id, mobNo);
	}

}

package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitwise.Data.User;
import com.bitwise.util.JDBCConnection;

public class UserDao {

	PreparedStatement st = null;
	ResultSet rs = null;
	Connection con = null;

	public UserDao() {
		System.out.println("*****From UserDao*********");
	}

	public boolean insertUser(User user) {
		con = JDBCConnection.jdbcConnection();
		String insertUserQuery = "insert into user(name,mobNo) values(?,?)";
		try {
			st = con.prepareStatement(insertUserQuery);
			st.setString(1, user.getName());
			st.setLong(2, user.getMobNo());

			int row = st.executeUpdate();

			return row > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}

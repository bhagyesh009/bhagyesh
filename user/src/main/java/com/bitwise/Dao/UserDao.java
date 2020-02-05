package com.bitwise.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bitwise.Data.User;
import com.bitwise.Data.Validation;
import com.bitwise.util.JDBCConnection;

public class UserDao {

	PreparedStatement st = null;
	ResultSet rs = null;
	Connection con = null;
	Validation validation = new Validation();
	User user = null;

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

	public boolean deleteUser(int id) {
		con = JDBCConnection.jdbcConnection();

		String deleteUserQuery = "update user set status=0 where id=? and status != 0";
		try {
			st = con.prepareStatement(deleteUserQuery);
			st.setInt(1, id);

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

	public User getUser(int id) {
		con = JDBCConnection.jdbcConnection();
		String getUserQuery = "select * from user where id=?";
		try {
			st = con.prepareStatement(getUserQuery);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs != null && rs.next()) {

				return new User(rs.getInt("id"), rs.getString("name"), rs.getLong("mobNo"), rs.getBoolean("status"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean updateUser(int id, long mobNo) {
		con = JDBCConnection.jdbcConnection();
		String getUserQuery = "update user set mobNo=? where id=? and status != 0";
		try {
			st = con.prepareStatement(getUserQuery);
			st.setLong(1, mobNo);
			st.setInt(2, id);
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
	
	public void name () {
		
	}

}

package com.bitwise.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnection {

	public static Connection jdbcConnection() {
		Properties property = new Properties();
		try {
			FileInputStream file = new FileInputStream("E:\\Users\\bhagyeshd\\git\\bhagyesh5\\user\\config.properties");
			property.load(file);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Class.forName(property.getProperty("driverName"));
			return  DriverManager.getConnection(property.getProperty("URL"), property.getProperty("username"),
					property.getProperty("password"));
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

}

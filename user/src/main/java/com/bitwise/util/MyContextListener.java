package com.bitwise.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
	@SuppressWarnings("rawtypes")

	public void contextInitialized(ServletContextEvent servletContextEvent) {

		Properties property = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("E:\\Users\\bhagyeshd\\git\\bhagyesh5\\user\\config.properties");
			property.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		Set set = property.entrySet();

		Iterator itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry entry = (Map.Entry) itr.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}

	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}

}
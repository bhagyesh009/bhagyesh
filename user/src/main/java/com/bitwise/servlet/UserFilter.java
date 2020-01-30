package com.bitwise.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class UserFilter implements Filter {
	@SuppressWarnings("rawtypes")

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Hi");
		Properties property = new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("C:\\Users\\Bhagyesh\\git\\bhagyesh\\user\\config.properties");
			property.load(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
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

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("InFilter");
		HttpServletRequest req = (HttpServletRequest) request;

		System.out.println("Header_Filter:" + req.getHeader("id"));

		chain.doFilter(request, response);
	}

}

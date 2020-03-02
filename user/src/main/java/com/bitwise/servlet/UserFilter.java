package com.bitwise.servlet;


import java.io.IOException;

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

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws  ServletException, IOException {
		System.out.println("InFilter");
		HttpServletRequest req = (HttpServletRequest) request;

		System.out.println("Header_Filter:" + req.getHeader("id"));

		chain.doFilter(request, response);
	}

}

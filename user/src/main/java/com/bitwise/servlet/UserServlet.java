package com.bitwise.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitwise.Dao.UserDao;
import com.bitwise.Data.Output;
import com.bitwise.Data.Output.Failure;
import com.bitwise.Data.Output.Success;
import com.bitwise.Data.User;
import com.bitwise.Data.Validation;
import com.bitwise.service.UserService;
import com.bitwise.util.JsonUtil;

@WebServlet(name = "UserServlet", urlPatterns = "/insertUser")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService userService = null;
	UserDao userDao = null;
	String userJsonString;
	User user = null;
	Validation validation = null;
	Output output = null;
	
	

	public UserServlet() {
		System.out.println("******From UserServlet***********");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService = new UserService();
		user = new User();
		validation = new Validation();
		output = new Output();
		List<Output.Success> outputSuccess = new ArrayList<Success>();
		List<Output.Failure> outputFailure = new ArrayList<Failure>();
		
	//	System.out.println("Header_ID:"+req.getHeader("id"));

		user = JsonUtil.convertJsonToJava(req.getReader().lines().collect(Collectors.joining()), User.class);

		boolean isNameValid = validation.isNameValid(user.getName());
		boolean isMobileNumberValid = validation.isMobileNumberValid(user.getMobNo());

		if (isNameValid && isMobileNumberValid) {

			if (userService.userModification(user)) {

				outputSuccess.add(output.new Success(200, "Sucessfully Inserted"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(1, outputSuccess, outputFailure)));
			} else {

				outputSuccess.add(output.new Success(400, "Not Inserted"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));
			}
		} else {
			if (false == isNameValid) {

				outputFailure.add(output.new Failure(600, "Name is not Valid Format"));
			}
			if (false == isMobileNumberValid) {
				outputFailure.add(output.new Failure(700, "Mobile Number is not Valid Format"));

			}

			resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));

		}

	}

}

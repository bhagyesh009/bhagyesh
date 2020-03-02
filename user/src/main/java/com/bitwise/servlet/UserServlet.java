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

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserService userService = null;
	UserDao userDao = null;
	String userJsonString;
	User user = null;
	Validation validation = null;
	Output output = null;
	List<Output.Success> outputSuccess = null;
	List<Output.Failure> outputFailure = null;

	public UserServlet() {
		System.out.println("******From UserServlet***********");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService = new UserService();
		validation = new Validation();
		output = new Output();
		outputSuccess = new ArrayList<Success>();
		outputFailure = new ArrayList<Failure>();

		user = JsonUtil.convertJsonToJava(req.getReader().lines().collect(Collectors.joining()), User.class);

		boolean isNameValid = validation.isNameValid(user.getName());
		boolean isMobileNumberValid = validation.isMobileNumberValid(user.getMobNo());

		if (isNameValid && isMobileNumberValid) {

			if (userService.userModification(user)) {

				outputSuccess.add(output.new Success(200, "Sucessfully Inserted"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(1, outputSuccess, outputFailure)));
			} else {

				outputSuccess.add(output.new Success(400, "User is already Present"));
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

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService = new UserService();
		output = new Output();
		outputSuccess = new ArrayList<Success>();
		outputFailure = new ArrayList<Failure>();

		user = JsonUtil.convertJsonToJava(req.getReader().lines().collect(Collectors.joining()), User.class);
		int id = Integer.parseInt(req.getParameter("id"));
		if (userService.userDeletion(id)) {

			outputSuccess.add(output.new Success(200, "ID: " + id + " Sucessfully Deleted"));
			resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(1, outputSuccess, outputFailure)));

		} else {

			outputFailure.add(output.new Failure(400, "ID :" + id + " not present in database"));
			resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService = new UserService();
		output = new Output();
		outputSuccess = new ArrayList<Success>();
		outputFailure = new ArrayList<Failure>();

		int id = Integer.parseInt(req.getParameter("id"));

		if (null != userService.userDetail(id) && true == userService.userDetail(id).getStatus()) {

			resp.getWriter().write(JsonUtil.convertJavaToJson(userService.userDetail(id)));
		} else {
			if (null != userService.userDetail(id) && false == userService.userDetail(id).getStatus()) {
				outputFailure.add(output.new Failure(200, "ID :" + id + " is not Active"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));
			} else {
				outputFailure.add(output.new Failure(400, "ID :" + id + " not present in database"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));
			}

		}

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService = new UserService();
		output = new Output();
		outputSuccess = new ArrayList<Success>();
		outputFailure = new ArrayList<Failure>();
		validation = new Validation();
		user = JsonUtil.convertJsonToJava(req.getReader().lines().collect(Collectors.joining()), User.class);
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isMobileNumberValid = validation.isMobileNumberValid(user.getMobNo());

		if (true == isMobileNumberValid) {
			if (true == userService.userUpdate(id, user.getMobNo())) {
				outputSuccess.add(output.new Success(200, "ID: " + id + " Sucessfully Upadted"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(1, outputSuccess, outputFailure)));
			} else {
				outputFailure.add(output.new Failure(400, "ID :" + id + " not present"));
				resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));

			}

		} else {
			outputFailure.add(output.new Failure(700, "Mobile Number is not Valid Format"));
			resp.getWriter().write(JsonUtil.convertJavaToJson(new Output(0, outputSuccess, outputFailure)));

		}

	}

}

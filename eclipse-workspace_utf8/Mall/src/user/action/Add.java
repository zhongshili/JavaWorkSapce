package user.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.JsonMobileUser;
import common.pojo.JsonMsg;
import common.pojo.User;
import common.util.DButil;
import user.dao.UserDAOImpl;
import user.service.UserServiceImpl;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserServiceImpl userService = new UserServiceImpl();
		JsonMobileUser jsonMobileUser =null;
		User user = new User();
		Connection conn = DButil.getConnection();
		ArrayList<User> userList = new ArrayList<User>();
		String phone = null;
		String password = null;
		boolean condition =false;
		request.setCharacterEncoding("utf-8");
		String callback = request.getParameter("callback");
		phone = request.getParameter("phone");
		password = request.getParameter("password");

		user.setPassword(password);
		user.setUserName(phone);
		user.setPhone(phone);
		
		UserDAOImpl userDAO = new UserDAOImpl(conn);
		try {
			userList = userDAO.select(user);
			for(User us:userList) {
				if(us.getPhone().equals(user.getPhone())) {
					jsonMobileUser = new JsonMobileUser("注册失败", false, null);
					condition=true;
					break;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}// 返回用户信息
		if(!condition) {
			jsonMobileUser = userService.insert(user);
		}
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(callback + "(" + new Gson().toJson(jsonMobileUser) + ")");;
		out.flush();
		out.close();
	}
}
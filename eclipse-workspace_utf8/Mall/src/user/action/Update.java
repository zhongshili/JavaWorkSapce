package user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.User;
import common.pojo.JsonMsg;
import user.service.UserServiceImpl;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserServiceImpl userService = new UserServiceImpl();
		
		User user = new User();
		User oldUser = new User();
		String userName = null;
		String phone = null;
		String address = null;
		String password = null;

		request.setCharacterEncoding("utf-8");
		userName = request.getParameter("userName");
		phone = request.getParameter("phone");
		address = request.getParameter("address");
		password = request.getParameter("password");
		oldUser.setPhone(phone);
		oldUser.setPassword(password);
		user=userService.findOrderInfoById(oldUser);

		user.setAddress(address);
		user.setUserName(userName);
		user.setPhone(phone);
		
		// 将数据传到service层
		JsonMsg jsonMsg = userService.update(user);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}

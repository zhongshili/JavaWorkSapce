package user.mobile.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.JsonMobile;
import common.pojo.JsonMobileUser;
import common.pojo.User;
import user.mobile.service.MobileService;

public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获得全部信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获得所有信息
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MobileService mobileService = new MobileService();

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		// APP端跨域请求需要带callback参数
		String callback = request.getParameter("callback");
		User user=new User();
		String userName = null;
		String sex = null;
		String phone = null;
		String userImg = null;
		String address = null;
		String password = null;
		String name = null;
		int age;
		request.setCharacterEncoding("utf-8");
//		userName = request.getParameter("userName");
//		sex = request.getParameter("sex");
		phone = request.getParameter("phone");
//		address = request.getParameter("address");
//		userImg = request.getParameter("userImg");
		password = request.getParameter("password");
//		name = request.getParameter("name");
//		age = Integer.parseInt(request.getParameter("age"));

//		user.setAddress(address);
//		user.setAge(age);
//		user.setName(name);
		user.setPassword(password);
//		user.setUserName(userName);
//		user.setUserImg(userImg);
		user.setPhone(phone);
//		user.setSex(sex);
//		user.setUserName(userName);
		// 执行查询，返回结果
		JsonMobileUser jsonMobileUser = mobileService.selectOne(user);
		PrintWriter out = response.getWriter();
		// 将数据返回APP端
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(jsonMobileUser) + ")");
		}
		out.flush();
		out.close();
	}
}
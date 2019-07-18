package userCart.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.UserCart;
import common.util.DButil;
import user.dao.UserDAOImpl;
import userCart.service.UserCartServiceImpl;
import common.pojo.JsonMobileUserCart;
import common.pojo.User;

public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获得全部信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获得所有信息
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = DButil.getConnection();
		UserCartServiceImpl userCartService = new UserCartServiceImpl();
		UserDAOImpl userDAOImpl = new UserDAOImpl(conn);
		UserCart userCart = new UserCart();

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		String callback = request.getParameter("callback");
		// 查询条件，没有条件则不设置
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		User user=new User();
		user.setPhone(phone);
		user.setPassword(password);
		try {
			user=userDAOImpl.findOrderInfoById(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String condition = request.getParameter("condition");
		if (condition != null && condition.length() > 0) {
			userCart.setCondition(condition);
		} else {
			userCart.setCondition("");
		}
		userCart.setUserName(user.getUserName());;
		// 分页条件，没有条件则不设置
		String pages = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (pages != null && pages.length() > 0 && rows != null && rows.length() > 0) {
			int page = Integer.parseInt(pages);
			int row = Integer.parseInt(rows);
			userCart.setLimit(" limit " + (page - 1) * row + "," + row);
		} else {
			userCart.setLimit("");
		}
		// 执行查询，返回结果
		JsonMobileUserCart jsonMobileUserCart = userCartService.selectByUserCart(userCart);
		PrintWriter out = response.getWriter();
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(jsonMobileUserCart) + ")");
		} else {
			out.print(new Gson().toJson(jsonMobileUserCart));
		}
		out.flush();
		out.close();
	}
}

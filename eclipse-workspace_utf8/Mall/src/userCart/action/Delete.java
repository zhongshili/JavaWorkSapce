package userCart.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.UserCart;
import common.pojo.JsonMsg;
import userCart.service.UserCartServiceImpl;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserCartServiceImpl userCartService = new UserCartServiceImpl();
		UserCart userCart = new UserCart();
		int productId;
		String userName = null;
		request.setCharacterEncoding("utf-8");
		String callback = request.getParameter("callback");
		productId = Integer.parseInt(request.getParameter("productId"));
		userName = request.getParameter("userName");
		
		userCart.setProductId(productId);
		userCart.setUserName(userName);
		// 调用service层执行删除操作
		JsonMsg jsonMsg = userCartService.delete(userCart);
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将数据返回APP端
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(jsonMsg) + ")");
		}
	}
}

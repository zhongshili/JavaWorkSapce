package commodity.mobile.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.JsonMobileCommodity;
import common.pojo.Commodity;
import commodity.mobile.service.MobileService;

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
		int productId = Integer.parseInt(request.getParameter("productId"));
		Commodity commodity=new Commodity();
		commodity.setProductId(productId);;
		// 执行查询，返回结果
		JsonMobileCommodity jsonMobileCommodity = mobileService.selectOne(commodity);
		PrintWriter out = response.getWriter();
		// 将数据返回APP端
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(jsonMobileCommodity) + ")");
		}
		out.flush();
		out.close();
	}
}
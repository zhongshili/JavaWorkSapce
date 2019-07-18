package home.promotion.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.HomePromotion;
import common.pojo.JsonRs;
import home.promotion.service.PromotionServiceImpl;

public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获得全部信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获得所有信息
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PromotionServiceImpl promotionService = new PromotionServiceImpl();
		HomePromotion promotion = new HomePromotion();

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		// APP端跨域请求需要带callback参数
		String callback = request.getParameter("callback");
		// 查询条件，没有条件则不设置
		String condition = request.getParameter("condition");
		if (condition != null && condition.length() > 0) {
			promotion.setCondition(condition);
		} else {
			promotion.setCondition("");
		}
		// 分页条件，没有条件则不设置
		String pages = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (pages != null && pages.length() > 0 && rows != null && rows.length() > 0) {
			int page = Integer.parseInt(pages);
			int row = Integer.parseInt(rows);
			promotion.setLimit(" limit " + (page - 1) * row + "," + row);
		} else {
			promotion.setLimit("");
		}
		// 执行查询，返回结果
		JsonRs JsonRS = promotionService.selectByPage(promotion);
		PrintWriter out = response.getWriter();
		// 将数据返回APP端
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(JsonRS) + ")");
		} else {	// 将数据返回管理端
			out.print(new Gson().toJson(JsonRS));
		}
		out.flush();
		out.close();
	}
}

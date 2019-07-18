package home.promotion.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.HomePromotion;
import common.pojo.JsonMsg;
import home.promotion.service.PromotionServiceImpl;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PromotionServiceImpl promotionService = new PromotionServiceImpl();
		HomePromotion promotion = new HomePromotion();
		int id;
		String position = null;
		String imgUrl = null;
		int productId;
		int page;

		request.setCharacterEncoding("utf-8");
		id = Integer.parseInt(request.getParameter("id"));
		position = request.getParameter("position");
		imgUrl = request.getParameter("imgUrl");
		productId = Integer.parseInt(request.getParameter("productId"));
		page = Integer.parseInt(request.getParameter("page"));

		promotion.setId(id);
		promotion.setPosition(position);
		promotion.setImgUrl(imgUrl);
		promotion.setProductId(productId);
		promotion.setPage(page);

		// 将数据传到service层
		JsonMsg jsonMsg = promotionService.update(promotion);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}

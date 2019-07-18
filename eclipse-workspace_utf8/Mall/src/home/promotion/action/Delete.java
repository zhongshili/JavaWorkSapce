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
import common.util.QiniuUtil;
import home.promotion.service.PromotionServiceImpl;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PromotionServiceImpl promotionService = new PromotionServiceImpl();
		HomePromotion promotion = new HomePromotion();
		int id;
		String imgUrl = null;
		String key = null;

		request.setCharacterEncoding("utf-8");
		id = Integer.parseInt(request.getParameter("id"));
		imgUrl = request.getParameter("imgUrl");
		if(imgUrl != null && imgUrl.length() > 0){
			key = imgUrl.split("/")[imgUrl.split("/").length - 1];
		}
		promotion.setId(id);
		// 调用service层执行删除操作
		JsonMsg jsonMsg = promotionService.delete(promotion);
		if(jsonMsg.isSuccess() && key != null ){
			QiniuUtil.delFile(key);
		}
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}

package home.advert.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.HomeAdvert;
import common.pojo.JsonMsg;
import common.util.CommonUtil;
import home.advert.service.HomeAdvertServiceImpl;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HomeAdvertServiceImpl advertService = new HomeAdvertServiceImpl();
		HomeAdvert advert = new HomeAdvert();
		int position ;
		int productId ;
		String imgUrl = null;
		int page;
		request.setCharacterEncoding("utf-8");
		position = Integer.parseInt(request.getParameter("position"));
		productId = Integer.parseInt(request.getParameter("productId"));
		imgUrl = request.getParameter("imgUrl");
		page = Integer.parseInt(request.getParameter("page"));
		String positionStr = CommonUtil.getAdvertPositionContent(position);
		advert.setPosition(positionStr);
		advert.setProductId(productId);
		advert.setImgUrl(imgUrl);
		advert.setPage(page);

		// 将数据传到service层
		JsonMsg jsonMsg = advertService.insert(advert);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}
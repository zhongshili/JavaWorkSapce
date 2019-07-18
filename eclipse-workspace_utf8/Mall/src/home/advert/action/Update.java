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

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HomeAdvertServiceImpl advertService = new HomeAdvertServiceImpl();
		HomeAdvert advert = new HomeAdvert();
		int id;
		int position ;
		int productId ;
		String imgUrl = null;
		int page;

		request.setCharacterEncoding("utf-8");
		id = Integer.parseInt(request.getParameter("id"));
		position = Integer.parseInt(request.getParameter("adTitle"));
		productId = Integer.parseInt(request.getParameter("adLeft"));
		imgUrl = request.getParameter("imgUrl");
		page = Integer.parseInt(request.getParameter("page"));
		String positionStr = CommonUtil.getAdvertPositionContent(position);
		advert.setId(id);
		advert.setPosition(positionStr);
		advert.setProductId(productId);
		advert.setImgUrl(imgUrl);
		advert.setPage(page);

		// 将数据传到service层
		JsonMsg jsonMsg = advertService.update(advert);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}

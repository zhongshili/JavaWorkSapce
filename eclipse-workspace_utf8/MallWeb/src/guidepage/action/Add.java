package guidepage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.GuidePage;
import common.pojo.JsonMsg;
import guidepage.service.GuidePageServiceImpl;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GuidePageServiceImpl guideService = new GuidePageServiceImpl();
		GuidePage guide = new GuidePage();
		String adTitle = null;
		String adLeft = null;
		String adRight = null;
		String imgUrl = null;
		int page;
		request.setCharacterEncoding("utf-8");
		adTitle = request.getParameter("adTitle");
		adLeft = request.getParameter("adLeft");
		adRight = request.getParameter("adRight");
		imgUrl = request.getParameter("imgUrl");
		page = Integer.parseInt(request.getParameter("page"));

		guide.setAdTitle(adTitle);
		guide.setAdLeft(adLeft);
		guide.setAdRight(adRight);
		guide.setImgUrl(imgUrl);
		guide.setPage(page);

		// 将数据传到service层
		JsonMsg jsonMsg = guideService.insert(guide);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}
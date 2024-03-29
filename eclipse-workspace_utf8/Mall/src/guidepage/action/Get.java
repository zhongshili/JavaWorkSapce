package guidepage.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.GuidePage;
import common.pojo.JsonRs;
import guidepage.service.GuidePageServiceImpl;

public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获得全部信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获得所有信息
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GuidePageServiceImpl guideService = new GuidePageServiceImpl();
		GuidePage guide = new GuidePage();

		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		String callback = request.getParameter("callback");
		// 查询条件，没有条件则不设置
		String condition = request.getParameter("condition");
		if (condition != null && condition.length() > 0) {
			guide.setCondition(condition);
		} else {
			guide.setCondition("");
		}
		// 分页条件，没有条件则不设置
		String pages = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (pages != null && pages.length() > 0 && rows != null && rows.length() > 0) {
			int page = Integer.parseInt(pages);
			int row = Integer.parseInt(rows);
			guide.setLimit(" limit " + (page - 1) * row + "," + row);
		} else {
			guide.setLimit("");
		}
		// 执行查询，返回结果
		JsonRs JsonRS = guideService.selectByPage(guide);
		PrintWriter out = response.getWriter();
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(JsonRS) + ")");
		} else {
			out.print(new Gson().toJson(JsonRS));
		}
		out.flush();
		out.close();
	}
}

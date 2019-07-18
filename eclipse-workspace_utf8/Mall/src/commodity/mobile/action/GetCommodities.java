package commodity.mobile.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.util.DButil;
import common.pojo.Commodity;
import common.pojo.CommodityType;
import common.pojo.JsonMobileCommodities;
import commodity.mobile.service.MobileService;
import commoditytype.dao.CommodityTypeDAOImpl;

public class GetCommodities extends HttpServlet {
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
		String productTypeName = request.getParameter("productTypeName");
		Commodity commodity=new Commodity();
		CommodityType commodityType=new CommodityType();
		commodityType.setProductTypeName(productTypeName);
		Connection conn = DButil.getConnection();
		CommodityTypeDAOImpl commodityTypeDAO  = new CommodityTypeDAOImpl(conn);
		try {
			commodityType=commodityTypeDAO.findOrderInfoById(commodityType);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		commodity.setProductTypeId(commodityType.getProductTypeId());
		// 执行查询，返回结果
		JsonMobileCommodities jsonMobileCommodities = mobileService.selectAll(commodity);
		PrintWriter out = response.getWriter();
		// 将数据返回APP端
		if (callback != null && callback.length() > 0) {
			out.print(callback + "(" + new Gson().toJson(jsonMobileCommodities) + ")");
		}
		out.flush();
		out.close();
	}
}
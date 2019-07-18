package commoditytype.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.pojo.Commodity;
import common.pojo.JsonMsg;
import commodity.service.CommodityServiceImpl;

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CommodityServiceImpl commodityService = new CommodityServiceImpl();
		Commodity commodity = new Commodity();
		int productId;
		float productPrice;
		String productTitle=null;
		String productCarriage=null;
		String productAddressRigger=null;
		int productSendCredit;
		String productShopName=null;
		String productShopUrl=null;
		int inventory;
		int productTypeId;
		String productImg=null;
		request.setCharacterEncoding("utf-8");
		
		productId = Integer.parseInt(request.getParameter("productId"));
		productPrice = Float.parseFloat(request.getParameter("productPrice"));
		productTitle = request.getParameter("productTitle");
		productCarriage = request.getParameter("productCarriage");
		productAddressRigger = request.getParameter("productAddressRigger");
		productSendCredit = Integer.parseInt(request.getParameter("productSendCredit"));
		productShopName = request.getParameter("productShopName");
		productShopUrl = request.getParameter("productShopUrl");
		inventory = Integer.parseInt(request.getParameter("inventory"));
		productTypeId = Integer.parseInt(request.getParameter("productTypeId"));
		productImg = request.getParameter("productImg");

		commodity.setProductId(productId);
		commodity.setProductPrice(productPrice);
		commodity.setProductTitle(productTitle);
		commodity.setProductCarriage(productCarriage);
		commodity.setProductAddressRigger(productAddressRigger);
		commodity.setProductSendCredit(productSendCredit);
		commodity.setProductShopName(productShopName);
		commodity.setProductShopUrl(productShopUrl);
		commodity.setProductImg(productImg);
		commodity.setInventory(inventory);
		commodity.setProductTypeId(productTypeId);
		// 将数据传到service层
		JsonMsg jsonMsg = commodityService.update(commodity);
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(jsonMsg));
	}
}

package common.token;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import common.util.QiniuUtil;

public class Get extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 获得全部信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// 获得所有信息
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String key = request.getParameter("key");
		PrintWriter out = response.getWriter(); // 用PrintWriter对象将返回结果写入服务器
		Map<String, String> map = new HashMap<>();
		String token = QiniuUtil.getToken(key); 	// 生成普通上传的Token
		map.put("token", token);
		out.print(new Gson().toJson(map));
		out.flush();
		out.close();
	}
}

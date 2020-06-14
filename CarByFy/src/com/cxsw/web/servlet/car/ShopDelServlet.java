package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cxsw.web.service.ShopService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/ShopDelServlet")
public class ShopDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		ShopService shopService=new ShopService();
		try {
			boolean result=shopService.delShop(id);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "车店信息删除成功");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车店信息删除失败");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
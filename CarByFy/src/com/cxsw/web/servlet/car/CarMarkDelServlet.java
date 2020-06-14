package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/CarMarkDelServlet")
public class CarMarkDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		CarMarkService carMarkService=new CarMarkService();
		try {
			boolean result=carMarkService.carMarkDel(id);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "³µÁ¾Æ·ÅÆÉ¾³ý³É¹¦");
				request.getRequestDispatcher("CarMarkQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "³µÁ¾Æ·ÅÆÉ¾³ýÊ§°Ü");
				request.getRequestDispatcher("CarMarkQueryServlet").forward(request, response);
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
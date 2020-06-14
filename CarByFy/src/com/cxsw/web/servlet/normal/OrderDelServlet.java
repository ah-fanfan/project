package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.OrderService;
import com.cxsw.web.service.TestService;
import com.cxsw.web.service.UserService;
import com.cxsw.web.servlet.LoginServlet;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/OrderDelServlet")
public class OrderDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String idString=request.getParameter("id");
		String s[]=idString.split(",");
		int id=Integer.parseInt(s[0]);
		OrderService orderService=new OrderService();
		if(s[1].equals("用户")) {
			try {
				boolean result = orderService.orderDel(id);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "订单信息删除成功");
					request.getRequestDispatcher("OrderByIdCardServlet?idcard="+LoginServlet.idCard).forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "订单信息删除失败");
					request.getRequestDispatcher("OrderByIdCardServlet?idcard="+LoginServlet.idCard).forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
	
			try {
				boolean 	result = orderService.orderDel(id);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "订单信息删除成功");
					request.getRequestDispatcher("OrderQueryServlet").forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "订单信息删除失败");
					request.getRequestDispatcher("OrderQueryServlet").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
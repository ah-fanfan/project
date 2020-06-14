package com.cxsw.web.servlet.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Order;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.pojo.User;
import com.cxsw.web.service.OrderService;
import com.cxsw.web.service.TestService;
import com.cxsw.web.service.UserService;
import com.cxsw.web.servlet.LoginServlet;
import com.cxsw.web.util.PageBean;
@WebServlet("/OrderByIdCardServlet")
public class OrderByIdCardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
//		String phone=request.getParameter("user_phone");
//		System.out.println(phone);
		int  pageNumber,pageSize;
		String pageNumberStr=request.getParameter("pageNumber");
		String pageSizeStr=request.getParameter("pageSize");
         if(pageNumberStr==null&&pageSizeStr==null) {
        	   pageNumber=1;
     		 pageSize=6;
		}else {
			  pageNumber=Integer.parseInt(pageNumberStr);
			 pageSize=Integer.parseInt(pageSizeStr);
		}
		OrderService orderService=new OrderService();
		try {
			// System.out.println(LoginServlet.idCard);
			    PageBean<Order> orderPage=orderService.getPageBeanByIdCard(pageNumber, pageSize, LoginServlet.idCard);
//			    System.out.println(orderPage.getTotalPage());
//			    System.out.println(orderPage.getPageNumber());
				request.setAttribute("orderPage", orderPage);
			request.getRequestDispatcher("/beanclass/user/orderQuery.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
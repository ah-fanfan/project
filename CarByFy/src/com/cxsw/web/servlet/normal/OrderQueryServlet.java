package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Order;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.service.OrderService;
import com.cxsw.web.service.TestService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.PageBean;
@WebServlet("/OrderQueryServlet")
public class OrderQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
       String id=request.getParameter("id");
//	System.out.println(idString);
		String key = request.getParameter("key");
		//System.out.println(key);
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
		PageBean<Order> orderPage;
		try {
			orderPage = orderService.getPageBean(pageNumber, pageSize, key);
			//System.out.println(orderPage.getList());
			request.setAttribute("orderPage", orderPage);
			request.setAttribute("key", key);
			System.out.println(id);
			if(id.equals("超级管理员")) {
				id="admin";
			}else if(id.equals("管理员")) {
				id="normal";
			}
			request.getRequestDispatcher("/beanclass/"+id+"/orderQuery.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
		
		
	}

}

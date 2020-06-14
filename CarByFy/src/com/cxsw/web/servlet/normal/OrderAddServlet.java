package com.cxsw.web.servlet.normal;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cxsw.web.pojo.Order;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.service.OrderService;
import com.cxsw.web.service.TestService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;

@WebServlet("/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		Map<String, String> map=fileuploadUtil.upload(request);
		
		 OrderService orderService=new OrderService();
		Order order=new Order();
	    try {
	        String string=map.get("car_name").toString();
	        char s[]=string.toCharArray();
	        String string2="";
	        for(char a:s) {
	        	if(a>='0'&&a<='9') {
	        	string2+=a;
	        	}else{
	        		break;
	        	}
	        }
	        String carName=string.replace(string2, "");
	        Integer carId=Integer.parseInt(string2);
			BeanUtils.populate(order, map);
	      	order.setCar_name(carName);
		    order.setCar_id(carId);
			boolean flag= orderService.addOrder(order);
			if(flag&&id.equals("用户")) {
				CookieUtil.addCookie(response, "operation_msg", "订单信息添加成功");
				request.getRequestDispatcher("OrderByIdCardServlet").forward(request, response);
			}else if(flag&&!id.equals("用户")){
				CookieUtil.addCookie(response, "operation_msg", "订单信息添加成功");
				request.getRequestDispatcher("OrderQueryServlet").forward(request, response);
			}else if(!flag&&id.equals("用户")) {
				CookieUtil.addCookie(response, "operation_msg", "订单信息失败");
				request.getRequestDispatcher("OrderByIdCardServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "订单信息失败");
				request.getRequestDispatcher("OrderQueryServlet").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
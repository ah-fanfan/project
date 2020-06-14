package com.cxsw.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cxsw.web.dao.EmployeeDao;
import com.cxsw.web.pojo.Car;
import com.cxsw.web.pojo.CarKind;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.pojo.Employee;
import com.cxsw.web.pojo.Shop;
import com.cxsw.web.pojo.User;
import com.cxsw.web.service.CarKindService;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.service.CarService;
import com.cxsw.web.service.EmployeeService;
import com.cxsw.web.service.ShopService;
import com.cxsw.web.service.UserService;
@WebServlet("/mark_and_kind")
public class MarkAndKindServlet extends HttpServlet {
	private final CarMarkService carMarkService=new CarMarkService();
	private final CarKindService carKindService=new CarKindService();
	private final ShopService shopService=new ShopService();
	private final CarService carService=new CarService();
	private final EmployeeService employeeService=new EmployeeService();
	private final UserService userService=new UserService();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String method = req.getParameter("method");
		if (null != method && !"".equals(method))
		{
			if ("initMark".equals(method))
			{
			
					try {
						initMark(req, resp);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else if("initKind".equals(method)) {
						try {
							initKind(req, resp);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			} else if("initCar".equals(method)) {
				try {
					initCar(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("initShop".equals(method)) {
				try {
					initShop(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("initEmployee".equals(method)) {
				try {
					initEmployee(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("initUser".equals(method)) {
				try {
					initUser(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("initPhone".equals(method)){
				try {
					initPhone(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	private void initMark(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<CarMark> markList = carMarkService.selectAll();
		String jsonStr = JSON.toJSONString(markList);
		out.print(jsonStr);
		
	}
	
	private void initKind(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<CarKind> provList = carKindService.selectAll();
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}
	
	private void initShop(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<Shop> provList = shopService.selectAll();
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}
	
	private void initCar(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<Car> provList = carService.selectAll();
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}
	private void initEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<Employee> provList = employeeService.selectAll();
		//System.out.println(provList);
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}
	private void initUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<User> provList = userService.selectAll();
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}
	private void initPhone(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String name=req.getParameter("Code");
	//	System.out.println(name);
		List<User> user = userService.selectPhone(name);
		//System.out.println(user);
		String jsonStr = JSON.toJSONString(user);
		out.print(jsonStr);
		
	}
	







	

}

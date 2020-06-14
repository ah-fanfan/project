package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.CarKind;
import com.cxsw.web.service.CarKindService;
import com.cxsw.web.service.CarService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/CarDelServlet")
public class CarDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		
		CarService carService=new CarService();
		try {
			if(carService.carDel(id)) {
				CookieUtil.addCookie(response, "operation_msg", "车辆信息删除成功");
				request.getRequestDispatcher("CarQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车辆信息删除失败");
				request.getRequestDispatcher("CarQueryServlet").forward(request, response);
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
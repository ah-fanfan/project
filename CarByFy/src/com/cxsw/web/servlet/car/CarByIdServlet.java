package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Car;
import com.cxsw.web.service.CarService;
@WebServlet("/CarByIdServlet")
public class CarByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String idStr=request.getParameter("id");
		String mess[]=idStr.split(",");
		Integer id=Integer.parseInt(mess[0]);
		CarService carService=new CarService();
		try {
			Car car=carService.selectOne(id);
			if(mess[1].equals("详情")) {
				request.setAttribute("car", car);
				request.getRequestDispatcher("/beanclass/car/carById.jsp").forward(request, response);
			}
			if(mess[1].equals("修改")){
				request.setAttribute("car", car);
				request.getRequestDispatcher("/beanclass/car/carShow.jsp").forward(request, response);
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
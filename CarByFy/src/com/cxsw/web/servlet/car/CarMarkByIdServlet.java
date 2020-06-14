package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.service.CarMarkService;
@WebServlet("/CarMarkByIdServlet")
public class CarMarkByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String idStr=request.getParameter("id");
		String mess[]=idStr.split(",");
		Integer id=Integer.parseInt(mess[0]);
		CarMarkService carMarkService=new CarMarkService();
		try {
			CarMark carMark=carMarkService.selectOne(id);
			if(mess[1].equals("详情")) {
				request.setAttribute("carMark", carMark);
				request.getRequestDispatcher("/beanclass/car/carMarkById.jsp").forward(request, response);
			}
			if(mess[1].equals("修改")){
				request.setAttribute("carMark", carMark);
				request.getRequestDispatcher("/beanclass/car/carMarkShow.jsp").forward(request, response);
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
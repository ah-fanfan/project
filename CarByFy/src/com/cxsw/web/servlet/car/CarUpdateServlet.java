package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Car;
import com.cxsw.web.service.CarService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/CarUpdateServlet")
public class CarUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String mark=request.getParameter("mark");
		String kind=request.getParameter("kind");
		String name=request.getParameter("name");
		String conf_style=request.getParameter("conf_style");
		Integer seat_num=Integer.parseInt(request.getParameter("seat_num"));
		Integer door_num=Integer.parseInt(request.getParameter("door_num"));
		String outimg=request.getParameter("outimg");
		String inimg=request.getParameter("inimg");
//		System.out.println(outimg);
//		System.out.println(inimg);
		if(outimg==null||outimg.equals("")) {//娌℃敼
			outimg=request.getParameter("oldImg1");
			//System.out.println(outimg);
		}else {
			outimg="/upload/"+outimg;
		}
		if(inimg==null||inimg.equals("")) {
			inimg=request.getParameter("oldImg2");
			//System.err.println(inimg);
		}else {
			inimg="/upload/"+inimg;
		}
		Integer comment=Integer.parseInt(request.getParameter("comment"));
		String fuel_type=request.getParameter("fuel_type");
		String transmission_type=request.getParameter("transmission_type");
		String seat_material=request.getParameter("seat_material");
		Integer havenavigation=Integer.parseInt(request.getParameter("havenavigation"));
		Integer havetopwindow=Integer.parseInt(request.getParameter("havetopwindow"));
		float price=Float.parseFloat(request.getParameter("price"));
		Integer state=Integer.parseInt(request.getParameter("state"));
		Car car=new Car(id, mark, kind,  name, conf_style, seat_num, door_num, outimg, inimg, fuel_type,
				transmission_type, seat_material, havenavigation, havetopwindow, price, comment, state);
		//System.out.println(car);
		CarService carService=new CarService();
		boolean result;
		try {
			result = carService.updateOne(car);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "车辆信息修改成功");
				request.getRequestDispatcher("CarQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车辆信息修改失败");
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

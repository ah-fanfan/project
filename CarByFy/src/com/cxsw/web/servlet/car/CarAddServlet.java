package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cxsw.web.pojo.Car;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.service.CarService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/CarAddServlet")
public class CarAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String> map=fileuploadUtil.upload(request);
		//String outimg=request.getParameter("outimg");
		//String inimg=request.getParameter("inimg");
		Car car=new Car();
		CarService carService=new CarService();
			try {
				System.out.println(map);
				BeanUtils.populate(car, map);
				//car.setOutimg(outimg);
				//car.setInimg(inimg);
				boolean result=carService.addCar(car);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "车辆信息添加成功");
					request.getRequestDispatcher("CarQueryServlet").forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "车辆信息添加失败");
					request.getRequestDispatcher("CarQueryServlet").forward(request, response);
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
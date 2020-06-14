package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/CarMarkUpdateServlet")
public class CarMarkUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String car_Mark=request.getParameter("car_mark");
		String img="/upload/"+request.getParameter("img");
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		CarMark carMark=new CarMark(id,car_Mark,img,comment,state); 
		CarMarkService carMarkService=new CarMarkService();
		boolean result;
		try {
			result = carMarkService.updateOne(carMark);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "车辆品牌修改成功");
				request.getRequestDispatcher("CarMarkQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车辆品牌修改失败");
				request.getRequestDispatcher("CarMarkQueryServlet").forward(request, response);
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

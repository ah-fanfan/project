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
import com.cxsw.web.util.CookieUtil;
@WebServlet("/CarKindAddServlet")
public class CarKindAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String kindName=request.getParameter("Kind_name");
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		//System.out.println(state);
		CarKind carKind=new CarKind(0,kindName,comment,state);
		CarKindService carKindService=new CarKindService();
		try {
			if(carKindService.addCarKind(carKind)) {
				CookieUtil.addCookie(response, "operation_msg", "车辆类型添加成功");
				request.getRequestDispatcher("CarKindQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车辆类型添加失败");
				request.getRequestDispatcher("CarKindQueryServlet").forward(request, response);
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
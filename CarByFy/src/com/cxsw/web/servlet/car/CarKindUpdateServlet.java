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
@WebServlet("/CarKindUpdateServlet")
public class CarKindUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String kindName=request.getParameter("kind_name");
		String comment=request.getParameter("comment");
		String stateStr=request.getParameter("state");
		int state=Integer.parseInt(stateStr);
		CarKind carKind=new CarKind(id,kindName,comment,state);
		CarKindService carKindService=new CarKindService();
		try {
			if(carKindService.updateOne(carKind)) {
				CookieUtil.addCookie(response, "operation_msg", "车辆类型修改成功");
				request.getRequestDispatcher("CarKindQueryServlet").forward(request, response);	
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车辆类型修改失败");
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
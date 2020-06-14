package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.pojo.User;
import com.cxsw.web.pojo.liandong.Province;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.service.NormalService;
import com.cxsw.web.service.UserService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("user_name");
		String psw=request.getParameter("user_psw");
		String idcard=request.getParameter("user_idcard");
		Integer age=Integer.parseInt(request.getParameter("user_age"));
		String sex=request.getParameter("user_sex");
		String phone=request.getParameter("user_phone");
		String address=request.getParameter("province")+request.getParameter("city")+request.getParameter("area");
	
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		User user=new User(id, name, psw, idcard, phone, age, sex, address, comment, state);
		UserService userService=new UserService();
		boolean result;
		try {
			result = userService.updateUser(user);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "用户信息修改成功");
				request.getRequestDispatcher("UserQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "用户信息修改失败");
				request.getRequestDispatcher("UserQueryServlet").forward(request, response);
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

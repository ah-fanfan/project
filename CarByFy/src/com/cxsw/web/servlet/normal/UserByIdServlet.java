package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.User;
import com.cxsw.web.service.UserService;
@WebServlet("/UserByIdServlet")
public class UserByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String idString=request.getParameter("id");
		String s[]=idString.split(",");
		Integer id=Integer.parseInt(s[0]);
		UserService userService=new UserService();
		try {
			User user=userService.selectOne(id);
			if(s[1].equals("查询")) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("beanclass/normal/userById.jsp").forward(request, response);
				
			}else{
				request.setAttribute("user", user);
			request.getRequestDispatcher("/beanclass/normal/userShow.jsp").forward(request, response);
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
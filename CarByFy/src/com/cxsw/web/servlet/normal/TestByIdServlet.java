package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Test;
import com.cxsw.web.pojo.User;
import com.cxsw.web.service.TestService;
import com.cxsw.web.service.UserService;
@WebServlet("/TestByIdServlet")
public class TestByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String idString=request.getParameter("id");
		Integer id=Integer.parseInt(idString);
		TestService testService=new TestService();
		try {
			    Test test=testService.selectOne(id);
				request.setAttribute("test", test);
			request.getRequestDispatcher("/beanclass/normal/testShow.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
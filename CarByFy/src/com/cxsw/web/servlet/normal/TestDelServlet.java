package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.TestService;
import com.cxsw.web.service.UserService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/TestDelServlet")
public class TestDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		TestService testService=new TestService();
		try {
			boolean result=testService.delTest(id);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", " ‘º›–≈œ¢…æ≥˝≥…π¶");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", " ‘º›–≈œ¢…æ≥˝ ß∞‹");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
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
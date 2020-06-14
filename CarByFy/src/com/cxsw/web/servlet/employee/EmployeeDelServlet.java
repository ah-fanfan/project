package com.cxsw.web.servlet.employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.EmployeeService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/EmployeeDelServlet")
public class EmployeeDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		EmployeeService employeeService=new EmployeeService();
		try {
			boolean result=employeeService.delEmployee(id);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "技工信息删除成功");
				request.getRequestDispatcher("EmployeeQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "技工信息删除失败");
				request.getRequestDispatcher("EmployeeQueryServlet").forward(request, response);
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
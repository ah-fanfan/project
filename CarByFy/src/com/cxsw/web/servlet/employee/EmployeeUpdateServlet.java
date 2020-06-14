package com.cxsw.web.servlet.employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import com.cxsw.web.pojo.Employee;
import com.cxsw.web.pojo.liandong.Province;
import com.cxsw.web.service.EmployeeService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String code=request.getParameter("emp_code");
		String idcard=request.getParameter("emp_idcard");
		String name=request.getParameter("emp_name");
		System.out.println(request.getParameter("emp_age"));
		Integer age=Integer.parseInt(request.getParameter("emp_age"));
		String dep=request.getParameter("emp_dep");
		String sex=request.getParameter("emp_sex");
		String phone=request.getParameter("emp_phone");
		String address=request.getParameter("province")+request.getParameter("city")+request.getParameter("area");
		String imgStr=request.getParameter("emp_img");
		if(imgStr==null||imgStr.equals("")) {
			imgStr=request.getParameter("oldImg");
		}else {
			imgStr="/upload/"+imgStr;
		}
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		Employee employee=new Employee(id, code, name, age, sex, dep, phone, idcard, address, imgStr, comment, state);
		EmployeeService employeeService=new EmployeeService();
		boolean result;
		try {
			result = employeeService.updateEmployee(employee);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "技工信息修改成功");
				request.getRequestDispatcher("EmployeeQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "技工信息修改失败");
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

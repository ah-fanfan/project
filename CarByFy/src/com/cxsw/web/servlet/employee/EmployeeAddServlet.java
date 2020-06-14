package com.cxsw.web.servlet.employee;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.cxsw.web.pojo.Employee;
import com.cxsw.web.service.EmployeeService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String> map=fileuploadUtil.upload(request);
		//System.out.println(map);
		//System.out.println(map);
		String address=map.get("province")+map.get("city")+map.get("area");
		Employee employee=new Employee();
		employee.setEmp_address(address);
		EmployeeService employeeService=new EmployeeService();
			try {
				
				BeanUtils.populate(employee, map);
				boolean result=employeeService.addEmployee(employee);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "技工信息添加成功");
					request.getRequestDispatcher("EmployeeQueryServlet").forward(request, response);
					
				}else {
					CookieUtil.addCookie(response, "operation_msg", "技工信息添加失败");
					request.getRequestDispatcher("EmployeeQueryServlet").forward(request, response);
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
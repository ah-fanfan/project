package com.cxsw.web.servlet.normal;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cxsw.web.pojo.Test;
import com.cxsw.web.service.TestService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;

@WebServlet("/TestAddServlet")
public class TestAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		Map<String, String> map=fileuploadUtil.upload(request);
		//System.out.println(map);
		 Date currentTime=new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH");
		 String t_date = formatter.format(currentTime);
		TestService testService=new TestService();
		Test test=new Test();
		test.setT_date(t_date);
	    try {
			BeanUtils.populate(test, map);
			//System.out.println(test);
			boolean flag= testService.addTest(test);
			if(flag&&id.equals("用户")) {
				CookieUtil.addCookie(response, "operation_msg", "试驾信息添加成功");
				request.getRequestDispatcher("TestByPhoneServlet").forward(request, response);
			}else if(flag&&!id.equals("用户")){
				CookieUtil.addCookie(response, "operation_msg", "试驾信息添加成功");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
			}else if(!flag&&id.equals("用户")) {
				CookieUtil.addCookie(response, "operation_msg", "试驾信息失败");
				request.getRequestDispatcher("TestByPhoneServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "试驾信息失败");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
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
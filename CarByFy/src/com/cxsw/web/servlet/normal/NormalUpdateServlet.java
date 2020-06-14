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
import com.cxsw.web.pojo.liandong.Province;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.service.NormalService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/NormalUpdateServlet")
public class NormalUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("ad_code");
		String psw=request.getParameter("ad_psw");
		String name=request.getParameter("ad_name");
		Integer age=Integer.parseInt(request.getParameter("ad_age"));
		String sex=request.getParameter("ad_sex");
		String phone=request.getParameter("ad_phone");
		String address=request.getParameter("province")+request.getParameter("city")+request.getParameter("area");
		String img="/upload/"+request.getParameter("img");
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		Admin admin=new Admin(id, code, psw, 2, name,age, img, sex, phone, null, null, null, address, comment, state);
		NormalService normalService=new NormalService();
		boolean result;
		try {
			result = normalService.updateNormal(admin);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "普通管理员信息修改成功");
				request.getRequestDispatcher("NormalQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "普通管理员信息修改失败");
				request.getRequestDispatcher("NormalQueryServlet").forward(request, response);
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

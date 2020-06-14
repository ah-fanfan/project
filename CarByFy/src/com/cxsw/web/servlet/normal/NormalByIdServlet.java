package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.service.NormalService;
@WebServlet("/NormalByIdServlet")
public class NormalByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		 String province="";
	     String city="";
	     String area="";
		String idString=request.getParameter("id");
		String s[]=idString.split(",");
		Integer id=Integer.parseInt(s[0]);
		NormalService normalService=new NormalService();
		try {
			Admin admin=normalService.selectOne(id);
			if(s[1].equals("详情")) {
				request.setAttribute("normal", admin);
				request.getRequestDispatcher("beanclass/normal_admin/normalById.jsp").forward(request, response);
				
			}else{
				request.setAttribute("normal", admin);
				String addstr=admin.getAd_address();
				if(addstr.indexOf("上海市")>=0||addstr.indexOf("北京市")>=0||addstr.indexOf("天津市")>=0||addstr.indexOf("重庆市")>=0) {
		         province=addstr.substring(0,3);
		         String arr[]=addstr.substring(3).split("县");
		         city=arr[0]+"县";
		         area=arr[1];
		        
				}
				else {
					String addStr[]=admin.getAd_address().split("省");
				    province=addStr[0]+"省";
					String arr[]=addStr[1].split("市");
					city=arr[0]+"市";
			        area=arr[1];
				}
				admin.setProvince(province);
				admin.setCity(city);
				admin.setArea(area);
				request.setAttribute("normal", admin);
			request.getRequestDispatcher("/beanclass/normal_admin/normalShow.jsp").forward(request, response);
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
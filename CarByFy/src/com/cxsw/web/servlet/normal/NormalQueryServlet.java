package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.service.NormalService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.PageBean;
@WebServlet("/NormalQueryServlet")
public class NormalQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
		//System.out.println(key);
		int  pageNumber,pageSize;
		String pageNumberStr=request.getParameter("pageNumber");
		String pageSizeStr=request.getParameter("pageSize");
         if(pageNumberStr==null&&pageSizeStr==null) {
        	   pageNumber=1;
     		 pageSize=6;
		}else {
			  pageNumber=Integer.parseInt(pageNumberStr);
			 pageSize=Integer.parseInt(pageSizeStr);
		}
		NormalService normalService=new NormalService();
		PageBean<Admin> normalPage;
		try {
			normalPage = normalService.getPageBean(pageNumber, pageSize, key);
			request.setAttribute("normalPage", normalPage);
			request.setAttribute("key", key);
			//CookieUtil.addCookie(response, "operation_msg", "EDRTFGYHUJK");
			request.getRequestDispatcher("/beanclass/normal_admin/normalQuery.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
		
		
	}

}

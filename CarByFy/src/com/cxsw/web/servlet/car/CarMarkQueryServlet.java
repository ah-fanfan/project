package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.PageBean;
@WebServlet("/CarMarkQueryServlet")
public class CarMarkQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String key = request.getParameter("key");
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
		CarMarkService carMarkService=new CarMarkService();
		PageBean<CarMark> carMarkPage;
		try {
			carMarkPage = carMarkService.getPageBean(pageNumber, pageSize, key);
			request.setAttribute("carMarkPage", carMarkPage);
			request.setAttribute("key", key);
			//CookieUtil.addCookie(response, "operation_msg", "EDRTFGYHUJK");
			request.getRequestDispatcher("/beanclass/car/carMarkQuery.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
		
		
	}

}

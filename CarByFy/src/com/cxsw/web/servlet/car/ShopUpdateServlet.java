
package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.Shop;
import com.cxsw.web.service.ShopService;
import com.cxsw.web.util.CookieUtil;
import com.mchange.v2.async.StrandedTaskReporting;
@WebServlet("/ShopUpdateServlet")
public class ShopUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String country=request.getParameter("area");
		String detailAddress=request.getParameter("detail_address");
		String name=request.getParameter("name");
		String img=request.getParameter("img");
		System.out.println(request.getParameter("oldImg"));
		if(img==null||img.equals("")) {
			img=request.getParameter("oldImg");
		}else {
			img="/upload/"+img;
		}
		System.out.println(img);
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		Shop shop=new Shop(id,province,city,country,detailAddress,name,img,comment,state);
		//System.out.println(shop);
		ShopService shopService=new ShopService();
		
		try {
			boolean 	flag = shopService.updateShop(shop);
			if(flag) {
				CookieUtil.addCookie(response, "operation_msg", "车店信息修改成功");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车店信息修改失败");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
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
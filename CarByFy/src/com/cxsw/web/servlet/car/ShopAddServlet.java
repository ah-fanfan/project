package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cxsw.web.pojo.Shop;
import com.cxsw.web.service.ShopService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/ShopAddServlet")
public class ShopAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String> map=fileuploadUtil.upload(request);
		ShopService service=new ShopService();
		Shop shop=new Shop();
		try {
			BeanUtils.populate(shop, map);
		//	System.out.println(shop);
			boolean res=service.addShop(shop);
			if(res) {
				CookieUtil.addCookie(response, "operation_msg", "车店信息添加成功");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "车店信息添加失败");
				request.getRequestDispatcher("ShopQueryServlet").forward(request, response);
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
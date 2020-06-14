package com.cxsw.web.servlet.normal;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.service.NormalService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/NormalAddServlet")
public class NormalAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String> map=fileuploadUtil.upload(request);
		String address=map.get("province")+map.get("city")+map.get("area");
		Admin admin=new Admin();
		admin.setAd_address(address);
		admin.setAd_power(2);
		NormalService normalService=new NormalService();
			try {
				BeanUtils.populate(admin, map);
				boolean result=normalService.addNormal(admin);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "普通管理员添加成功");
					request.getRequestDispatcher("NormalQueryServlet").forward(request, response);
					
				}else {
					CookieUtil.addCookie(response, "operation_msg", "普通管理员添加失败");
					request.getRequestDispatcher("NormalQueryServlet").forward(request, response);
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
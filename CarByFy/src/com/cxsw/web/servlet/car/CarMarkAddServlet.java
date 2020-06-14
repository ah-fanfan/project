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

import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.service.CarKindService;
import com.cxsw.web.service.CarMarkService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;
@WebServlet("/CarMarkAddServlet")
public class CarMarkAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Map<String, String> map=fileuploadUtil.upload(request);
		CarMark carMark=new CarMark();
		CarMarkService carMarkService=new CarMarkService();
			try {
				BeanUtils.populate(carMark, map);
				boolean result=carMarkService.addCarMark(carMark);
				if(result) {
					CookieUtil.addCookie(response, "operation_msg", "车辆品牌添加成功");
					request.getRequestDispatcher("CarMarkQueryServlet").forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "车辆品牌添加失败");
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
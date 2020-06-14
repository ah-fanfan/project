package com.cxsw.web.servlet.user;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.cxsw.web.pojo.User;
import com.cxsw.web.service.UserService;
import com.cxsw.web.util.CookieUtil;
import com.cxsw.web.util.fileuploadUtil;

@WebServlet("/UserRegisterServlet")
public class UserAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("user_name");
		String psw=request.getParameter("user_psw");
		String idcard=request.getParameter("user_idcard");
		String phone=request.getParameter("user_phone");
		String sex=request.getParameter("user_sex");
		Integer age=Integer.parseInt(request.getParameter("user_age"));
		String address=request.getParameter("province")+request.getParameter("city")+request.getParameter("area");
        String comment=request.getParameter("comment");
		User user=new User(0, name, psw, idcard, phone, age, sex,address, comment, 1);
	UserService userService=new UserService();
			try {
				boolean result=userService.userAdd(user);
				if(result) {
					request.setAttribute("user",user);
					CookieUtil.addCookie(response, "operation_msg", "×¢²á³É¹¦");
					request.getRequestDispatcher("CarQueryByUserServlet").forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "×¢²áÊ§°Ü");
					request.getRequestDispatcher("/beanclass/user/login.jsp").forward(request, response);
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
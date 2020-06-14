

package com.cxsw.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.User;
import com.cxsw.web.service.LoginService;
import com.cxsw.web.util.CookieUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService=new LoginService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String adCode=request.getParameter("adCode");
		String adPsw=request.getParameter("adPsw");
		Admin admin=new Admin();
		User user=new User();
		user.setUser_phone(adCode);
		user.setUser_psw(adPsw);
		admin.setAd_code(adCode);
		admin.setAd_psw(adPsw);
		try {
			Admin ad=loginService.login(admin);
			User u=loginService.login(user);
			if(ad != null&&u==null) {
				//锟叫讹拷权锟斤拷
				Integer power = ad.getAd_power();
				if(power == 1) {
					request.getSession().setAttribute("admin", ad);
					CookieUtil.addCookie(response, "operation_msg", "登陆成功");
					request.getRequestDispatcher("/beanclass/admin/index.jsp").forward(request, response);
				}else if(power == 2){
					request.getSession().setAttribute("admin", ad);
					CookieUtil.addCookie(response, "operation_msg", "登陆成功");
					request.getRequestDispatcher("/beanclass/normal/index.jsp").forward(request, response);
				}else {
					CookieUtil.addCookie(response, "operation_msg", "用户名或密输入错误");
				}
			}else if(u!=null&&ad==null){
	         userName=u.getUser_name();
			 userPhone=u.getUser_phone();
			 idCard=u.getUser_idcard();
				request.getSession().setAttribute("user", u);
				CookieUtil.addCookie(response, "operation_msg", "用户登陆成功");
				request.getRequestDispatcher("CarQueryByUserServlet").forward(request, response);
				System.out.println("登陆成功");
			}else {
				CookieUtil.addCookie(response, "operation_msg", "用户名或密输入错误");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static String userName=null;
	public static String userPhone=null;
	public static String idCard=null;
}






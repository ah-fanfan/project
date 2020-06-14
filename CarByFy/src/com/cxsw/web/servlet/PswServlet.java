package com.cxsw.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.LoginService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/PswServlet")
public class PswServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		LoginService loginService=new LoginService();
		String code=request.getParameter("code");
		String newPsaaWord=request.getParameter("newPsaaWord");
		String psw=request.getParameter("password");
		if(newPsaaWord.equals(psw)) {
		try {
			if(loginService.modifyPsw(psw, code)) {
				CookieUtil.addCookie(response, "operation_msg", "√‹¬Î–ﬁ∏ƒ≥…π¶");
			}else {
				CookieUtil.addCookie(response, "operation_msg", "√‹¬Î–ﬁ∏ƒ ß∞‹");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package com.cxsw.web.servlet.normal;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.service.TestService;
import com.cxsw.web.util.CookieUtil;
@WebServlet("/TestUpdateServlet")
public class TestUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String code=request.getParameter("t_code");
		String name=request.getParameter("user_name");
		String phone=request.getParameter("user_phone");
		String car=request.getParameter("t_car");
		String shop=request.getParameter("t_shop");
		String date=request.getParameter("t_date");
		String normal=request.getParameter("t_normal");
		String comment=request.getParameter("comment");
		Integer state=Integer.parseInt(request.getParameter("state"));
		Test test=new Test(id, code, phone, name, car, shop, date, normal, comment, state);
	TestService testService=new TestService();
		boolean result;
		try {
			result = testService.updateTest(test);
			if(result) {
				CookieUtil.addCookie(response, "operation_msg", "试驾信息修改成功");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
			}else {
				CookieUtil.addCookie(response, "operation_msg", "试驾信息修改失败");
				request.getRequestDispatcher("TestQueryServlet").forward(request, response);
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

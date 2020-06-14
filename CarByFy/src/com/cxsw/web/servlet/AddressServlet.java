package com.cxsw.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cxsw.web.pojo.liandong.Area;
import com.cxsw.web.pojo.liandong.City;
import com.cxsw.web.pojo.liandong.Province;
import com.cxsw.web.service.PCA_Service;
@WebServlet("/address")
public class AddressServlet extends HttpServlet {
	private final PCA_Service pca_Service=new PCA_Service();
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String method = req.getParameter("method");
		if (null != method && !"".equals(method))
		{
			if ("initProvince".equals(method))
			{
				try {
					initProvince(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if ("getCity".equals(method))
			{
				try {
					getCity(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if("getArea".equals(method)) {
				try {
					getArea(req,resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		
	}
	private void getArea(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		String cityCode = req.getParameter("cityCode");
		//System.out.println(cityCode+"SDFGHJKDFGHBJNMDFGHBJ");
		List<Area> areaList = pca_Service.getArea(cityCode);
		String jsonStr = JSON.toJSONString(areaList);
		out.print(jsonStr);
		
	}

	private void getCity(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
 
		String provCode = req.getParameter("provCode");
		//System.out.println(provCode+"77777777777777777777");
		List<City> cityList =pca_Service.getCity(provCode);
		//Gson.jar包转化json字符串
		String jsonStr = JSON.toJSONString(cityList);
		out.print(jsonStr);
 
	}

	private void initProvince(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException
	{
 
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		List<Province> provList = pca_Service.getProvince();
		String jsonStr = JSON.toJSONString(provList);
		out.print(jsonStr);
		
	}

	

}

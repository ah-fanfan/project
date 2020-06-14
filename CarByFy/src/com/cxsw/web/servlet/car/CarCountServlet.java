package com.cxsw.web.servlet.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.annotation.processing.SupportedSourceVersion;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.pojo.CarCount;
import com.cxsw.web.pojo.Share;
import com.cxsw.web.service.CarService;

@WebServlet("/CarCountServlet")
public class CarCountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		CarService carService=new CarService();
		try {
			List<CarCount> carCounts=carService.carCount();
			List<CarCount>  carMarks=carService.markCount();
			List<Share> shares=carService.getShare();
			List<CarCount> list=carService.getStock();
			//�������ת��
			String st[]=new String[list.size()];
			for(int i=0;i<list.size();i++) {
				st[i]=list.get(i).getMark()+list.get(i).getName();	
		}
			int t[]=new int [list.size()];
			for(int i=0;i<list.size();i++) {
				t[i]=list.get(i).getNum();
			}
			//��������ת��
			float [][]z=new float[12][4];
			for( int i=0;i<shares.size();i++) {
				int j=Integer.parseInt(shares.get(i).getFetch_time().substring(5, 7));
				switch(shares.get(i).getKind()){
				case "С�ͳ�":
					z[j-1][0]+=shares.get(i).getPrice();
					break;
				case "�����ͳ�":
					z[j-1][1]+=shares.get(i).getPrice();
					break;
				case "���ͳ�":
					z[j-1][2]+=shares.get(i).getPrice();
					break;
				case "SUV":
					z[j-1][3]+=shares.get(i).getPrice();
					break;
				}
			}
			
	
			//Ʒ������ת��
			int[] m=new int[carMarks.size()];
			String[] ma=new String[carMarks.size()];
		    for(  int i=0;i<m.length;i++) {
		    	m[i]=carCounts.get(i).getNum();
		    	ma[i]=carCounts.get(i).getMark();
		    }
			
			
			
         //��������ת��
			int a[]=new int[carCounts.size()];
			String s[]=new String [carCounts.size()];
		
		    for( int i=0;i<a.length;i++) {
		    	a[i]=carCounts.get(i).getNum();
		    	s[i]=carCounts.get(i).getMark()+carCounts.get(i).getName();
		    	System.out.println(s[i]);
		  
		    }
		    //������ݴ���
		    int t_length=t.length;
		    request.setAttribute("st", st);
		    request.setAttribute("t", t);
		    request.setAttribute("t_length", t_length);
		    //�������ݴ���
		    request.setAttribute("z",z);
		    //�������ݴ���
		    int length=a.length;
		    request.setAttribute("s", s);
		    request.setAttribute("length", length);
			request.setAttribute("a", a);
			//Ʒ�����ݴ���
		    int m_length=m.length;
		    request.setAttribute("m", m);
		    request.setAttribute("m_length", m_length);
			request.setAttribute("ma", ma);
			//System.out.println(request.getParameter("id"));
		 if(request.getParameter("id").equals("��������Ա")) {
			 request.getRequestDispatcher("beanclass/car/carCountShow.jsp").forward(request, response);
		 }else {
			 request.getRequestDispatcher("beanclass/user/carCountShow.jsp").forward(request, response);
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
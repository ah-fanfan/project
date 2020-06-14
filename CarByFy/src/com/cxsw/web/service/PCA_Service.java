package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.PCA_Dao;
import com.cxsw.web.pojo.liandong.Area;
import com.cxsw.web.pojo.liandong.City;
import com.cxsw.web.pojo.liandong.Province;

public class PCA_Service {
	 PCA_Dao pca_Dao=new PCA_Dao();
	public  List<Province> getProvince() throws SQLException{
		return pca_Dao.getProvince();
	}
	
	public List<City> getCity(String provinceid) throws SQLException{
		return pca_Dao.getCity(provinceid);
	}
	
	public  List<Area> getArea(String cityid) throws SQLException{
		return pca_Dao.getArea(cityid);
	}


}

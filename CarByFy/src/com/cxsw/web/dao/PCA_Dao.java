package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.pojo.liandong.Area;
import com.cxsw.web.pojo.liandong.City;
import com.cxsw.web.pojo.liandong.Province;
import com.cxsw.web.util.DataSourceUtils;

public class PCA_Dao {
	static QueryRunner queryRunner =new QueryRunner(DataSourceUtils.getDataSource());
	private  String sql=null;
	public  List<Province> getProvince() throws SQLException{
		sql="select * from  provinces";
		List<Province> list=queryRunner.query(sql, new BeanListHandler<Province>(Province.class));
		return list;
	}
	
	public   List<City> getCity(String provinceid) throws SQLException{
		sql="SELECT * FROM  cities WHERE provinceid IN(SELECT provinceid  FROM provinces WHERE province=?) ";
		List<City> list=queryRunner.query(sql, new BeanListHandler<City>(City.class),provinceid);
		return list;
	}
	
	public   List<Area> getArea(String cityid) throws SQLException{
		sql="SELECT * FROM  areas WHERE cityid IN(SELECT cityid FROM cities WHERE city=?)";
		List<Area> list=queryRunner.query(sql, new BeanListHandler<Area>(Area.class),cityid);
		return list;
	}

}

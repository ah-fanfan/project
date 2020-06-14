package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.cxsw.web.pojo.Car;
import com.cxsw.web.pojo.CarCount;
import com.cxsw.web.pojo.Share;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;


public class CarDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql;
	public boolean updateOne(Car car) throws SQLException {
		sql="update car_info set mark=?,kind=?,name=?,conf_style=?, seat_num=?,door_num=?,outimg=?,inimg=?,fuel_type=?,transmission_type=?,seat_material=?,havenavigation=?,havetopwindow=?,price=?,comment=?,state=? where id=?";
		int res=queryRunner.update(sql,car.getMark(),car.getKind(),car.getName(),car.getConf_style(),car.getSeat_num(),
				car.getDoor_num(),car.getOutimg(),car.getInimg(),car.getFuel_type(),car.getTransmission_type(),
				car.getSeat_material(),car.getHavenavigation(),car.getHavetopwindow(),car.getPrice(),
				car.getComment(),car.getState(),car.getId());
		return res>0?true:false;
	}

	public Car  selectOne(Integer id) throws SQLException {
		sql="select * from car_info where id = ?";
		Car car=queryRunner.query(sql, new BeanHandler<Car>(Car.class),id);
		return car;
	}
	
	public List<Car> getlist(PageBean<Car> pageBean,String key) throws SQLException{
		if(key == null || "".equals(key)) {
			sql="select * from car_info limit ?,?";
			List<Car> list=queryRunner.query(sql, new BeanListHandler<>(Car.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from car_info  "
					+ "where id LIKE '%"+key+"%' OR mark LIKE  '%"+key+"%' OR kind LIKE '%"+key+"%' OR state like '%"+key+"%' "
							+ "    OR name like '%"+key+"%'  OR conf_style like '%"+key+"%' OR seat_num like '%"+key+"%' OR door_num like '%"+key+"%'"
									+ " OR outimg like '%"+key+"%' OR inimg like '%"+key+"%' OR fuel_type like '%"+key+"%' OR transmission_type like '%"+key+"%' "
											+ "  OR seat_material like '%"+key+"%' OR havenavigation like '%"+key+"%' OR havetopwindow like '%"+key+"%' "
													+ " OR price like '%"+key+"%'  OR comment like '%"+key+"%' limit ?,?";
		}
		List<Car> list=queryRunner.query(sql, new BeanListHandler<>(Car.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from car_info";
		}else {
			sql="select count(*) from car_info "
					+ "where id LIKE '%"+key+"%' OR mark LIKE  '%"+key+"%' OR kind LIKE '%"+key+"%' OR state like '%"+key+"%' "
					+ "  OR name like '%"+key+"%'  OR conf_style like '%"+key+"%' OR seat_num like '%"+key+"%' OR door_num like '%"+key+"%'"
							+ " OR outimg like '%"+key+"%' OR inimg like '%"+key+"%' OR fuel_type like '%"+key+"%' OR transmission_type like '%"+key+"%' "
									+ "  OR seat_material like '%"+key+"%' OR havenavigation like '%"+key+"%' OR havetopwindow like '%"+key+"%' "
											+ " OR price like '%"+key+"%'  OR comment like '%"+key+"%' ";
		}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public boolean addCar(Car car) throws SQLException {
		sql="insert into car_info(mark,kind,name,conf_style,seat_num,door_num,outimg,inimg,fuel_type,transmission_type,seat_material,havenavigation,havetopwindow,price,COMMENT,state)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,car.getMark(),car.getKind(),car.getName(),car.getConf_style(),car.getSeat_num(),
				car.getDoor_num(),car.getOutimg(),car.getInimg(),car.getFuel_type(),car.getTransmission_type(),
				car.getSeat_material(),car.getHavenavigation(),car.getHavetopwindow(),car.getPrice(),
				car.getComment(),car.getState());
		return res>0?true:false;
	}
	  public boolean carDel(Integer id) throws SQLException {
	    	sql="delete from car_info where id=?";
	    	int res=queryRunner.update(sql,id);
	    	return res>0?true:false;
	    }
	  public List<Car> selectAll() throws SQLException{
		  sql="select * from car_info";
		  List<Car> cars=queryRunner.query(sql, new BeanListHandler<>(Car.class));
		  return cars;
	  }
	  
	  public List<CarCount> carCount() throws SQLException{
		  sql=" SELECT * FROM (SELECT car_id,COUNT(car_id) AS num FROM carorder GROUP BY car_id) AS a,"
		  		+" (SELECT id,mark,NAME FROM car_info WHERE id IN (SELECT car_id FROM carorder )) AS b WHERE a.car_id=b.id";
		  List<CarCount> list=queryRunner.query(sql, new BeanListHandler<CarCount>(CarCount.class));
		  return list;
	  }
	  public List<CarCount>  markCount() throws SQLException{
		  sql="SELECT * FROM (SELECT mark,SUM(num) AS num FROM (SELECT * FROM (SELECT car_id,COUNT(car_id) AS num FROM carorder GROUP BY car_id) AS a, " + 
		  		"		  		(SELECT id,mark FROM car_info WHERE id IN (SELECT car_id FROM carorder )) AS b WHERE a.car_id=b.id) AS c GROUP  BY mark) AS d ORDER BY num DESC ";
		  List<CarCount> carmark=queryRunner.query(sql, new BeanListHandler<>(CarCount.class));
		  return carmark;
	  }
	  public List<Share> getShare() throws SQLException{
		  sql="SELECT fetch_time,kind,price FROM (SELECT fetch_time,car_id,COUNT(car_id) FROM carorder GROUP BY fetch_time,car_id) AS a,car_info WHERE car_info.id=car_id";
		  List <Share> list=queryRunner.query(sql, new BeanListHandler<>(Share.class));
		  return list;
	  }
		  public List<CarCount> getStock() throws SQLException{
			  sql="SELECT COMMENT AS num,mark,NAME FROM car_info GROUP BY id";
			  List<CarCount> list=queryRunner.query(sql,new BeanListHandler<>(CarCount.class) );
			  return list;
		  }
}

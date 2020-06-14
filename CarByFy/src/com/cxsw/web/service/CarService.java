package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.CarDao;
import com.cxsw.web.pojo.Car;
import com.cxsw.web.pojo.CarCount;
import com.cxsw.web.pojo.Share;
import com.cxsw.web.util.PageBean;
;

public class CarService {
	CarDao carDao=new CarDao();
	  /** * @Title: addCarMark
	    * @Description: 车辆信息添加
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean addCar(Car car) throws SQLException {
	    	return carDao.addCar(car);
			
		}
	/** * @Title: carMarkDel
	    * @Description: 车辆信息删除
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean carDel(Integer id) throws SQLException {
    	return carDao.carDel(id);
		
	}
	
	/** * @Title: getAll
	    * @Description: 车辆信息模糊查询
	    * @param @param key
	    * @param @param page
	    * @param @return    设定文件
	    * @return PageUtils<CarKind>    返回类型
	    * @throws */
	public PageBean<Car> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
		PageBean< Car> pageBean=new PageBean<>(pageNumber, pageSize);
		//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
		List<Car> list=carDao.getlist(pageBean,key);
		//2.���ж��������� select count(*) from managerlist 
		int pageCount=carDao.getPageCount(key);
		//3.���ж���ҳ   
		int totalPage=pageBean.getTotalPage();
		pageBean.setPageCount(pageCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
	public Car  selectOne(Integer id) throws SQLException {
		return carDao.selectOne(id);
	}
	public boolean updateOne(Car car) throws SQLException {
		return carDao.updateOne(car);
	}
	  public List<Car> selectAll() throws SQLException{
		 return carDao.selectAll();
	  }
	  public List<CarCount> carCount() throws SQLException{
		return carDao.carCount();
	  }
	  public List<CarCount>  markCount() throws SQLException{
		  return carDao.markCount();
	  }
	  public List<Share> getShare() throws SQLException{
		  return carDao.getShare();
	  }
	  public List<CarCount> getStock() throws SQLException{
		  return carDao.getStock();
	  }

}

package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import com.cxsw.web.dao.CarMarkDao;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.util.PageBean;
;

public class CarMarkService {
	CarMarkDao carMarkDao=new CarMarkDao();
	  /** * @Title: addCarMark
	    * @Description: 品牌信息添加
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean addCarMark(CarMark carMark) throws SQLException {
	    	return carMarkDao.addCarMark(carMark);
			
		}
	/** * @Title: carMarkDel
	    * @Description: 品牌信息删除
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean carMarkDel(Integer id) throws SQLException {
    	return carMarkDao.CarMarkDel(id);
		
	}
	
	/** * @Title: getAll
	    * @Description: 品牌信息模糊查询
	    * @param @param key
	    * @param @param page
	    * @param @return    设定文件
	    * @return PageUtils<CarKind>    返回类型
	    * @throws */
	public PageBean<CarMark> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
		PageBean< CarMark> pageBean=new PageBean<>(pageNumber, pageSize);
		//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
		List<CarMark> list=carMarkDao.getlist(pageBean,key);
		//2.���ж��������� select count(*) from managerlist 
		int pageCount=carMarkDao.getPageCount(key);
		//3.���ж���ҳ   
		int totalPage=pageBean.getTotalPage();
		pageBean.setPageCount(pageCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
	public CarMark  selectOne(Integer id) throws SQLException {
		return carMarkDao.selectOne(id);
	}
	public boolean updateOne(CarMark carMark) throws SQLException {
		return carMarkDao.updateOne(carMark);
	}
	public List<CarMark>  selectAll() throws SQLException {
		return carMarkDao.selectAll();
	}
}

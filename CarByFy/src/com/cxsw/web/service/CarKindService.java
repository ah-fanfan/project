package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cxsw.web.dao.CarKindDao;
import com.cxsw.web.pojo.CarKind;
import com.cxsw.web.util.PageBean;
;

public class CarKindService {
	CarKindDao carKindDao=new CarKindDao();
	  /** * @Title: addCarKind
	    * @Description: 车型信息添加
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean addCarKind(CarKind carKind) throws SQLException {
	    	return carKindDao.addCarKind(carKind);
			
		}
	/** * @Title: CarKindDel
	    * @Description: 车型信息删除
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean CarKindDel(Integer id) throws SQLException {
    	return carKindDao.carKindDel(id);
		
	}
	
	/** * @Title: getAll
	    * @Description: 车型信息模糊查询
	    * @param @param key
	    * @param @param page
	    * @param @return    设定文件
	    * @return PageUtils<CarKind>    返回类型
	    * @throws */
	public PageBean<CarKind> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
		PageBean< CarKind> pageBean=new PageBean<>(pageNumber, pageSize);
		//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
		List<CarKind> list=carKindDao.getlist(pageBean,key);
		//2.���ж��������� select count(*) from managerlist 
		int pageCount=carKindDao.getPageCount(key);
		//3.���ж���ҳ   
		int totalPage=pageBean.getTotalPage();
		pageBean.setPageCount(pageCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
	public CarKind  selectOne(Integer id) throws SQLException {
		return carKindDao.selectOne(id);
	}
	public boolean updateOne(CarKind carKind) throws SQLException {
		return carKindDao.updateOne(carKind);
	}
	public List<CarKind>  selectAll() throws SQLException {
		return carKindDao.selectAll();
		}
}

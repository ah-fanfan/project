package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.CarDao;
import com.cxsw.web.dao.OrderDao;
import com.cxsw.web.pojo.Order;
import com.cxsw.web.util.PageBean;
;

public class OrderService {
OrderDao orderDao=new OrderDao();
	  /** * @Title: addCarMark
	    * @Description: 车辆信息添加
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean addOrder(Order order) throws SQLException {
	    	return orderDao.addOrder(order);
			
		}
	/** * @Title: carMarkDel
	    * @Description: 车辆信息删除
	    * @param @param carKind
	    * @param @return
	    * @param @throws SQLException    设定文件
	    * @return boolean    返回类型
	    * @throws */
	public boolean orderDel(Integer id) throws SQLException {
    	return orderDao.orderDel(id);
		
	}
	
	/** * @Title: getAll
	    * @Description: 车辆信息模糊查询
	    * @param @param key
	    * @param @param page
	    * @param @return    设定文件
	    * @return PageUtils<CarKind>    返回类型
	    * @throws */
	public PageBean<Order> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
		PageBean< Order> pageBean=new PageBean<>(pageNumber, pageSize);
		//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
		List<Order> list=orderDao.getlist(pageBean,key);
		//2.���ж��������� select count(*) from managerlist 
		int pageCount=orderDao.getPageCount(key);
		//3.���ж���ҳ   
		int totalPage=pageBean.getTotalPage();
		pageBean.setPageCount(pageCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Order> getPageBeanByIdCard(int pageNumber, int pageSize,String  key) throws SQLException {
		PageBean< Order> pageBean=new PageBean<>(pageNumber, pageSize);
		//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
		List<Order> list=orderDao.getlistByIdCard(pageBean, key);
		//2.���ж��������� select count(*) from managerlist 
		int pageCount=orderDao.getPageCountByIdCard(key);
		//3.���ж���ҳ   
		int totalPage=pageBean.getTotalPage();
		pageBean.setPageCount(pageCount);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		return pageBean;
	}
	public Order  selectOne(Integer id) throws SQLException {
		return orderDao.selectOne(id);
	}
}

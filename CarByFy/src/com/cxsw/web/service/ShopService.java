package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.ShopDao;
import com.cxsw.web.pojo.Shop;
import com.cxsw.web.util.PageBean;

public class ShopService {
ShopDao  shopDao =new ShopDao();
public boolean addShop(Shop shop) throws SQLException {
	return shopDao.addShop(shop);
}
public boolean delShop(Integer id) throws SQLException {
	return shopDao.delShop(id);
}
public boolean updateShop(Shop shop) throws SQLException {
	return shopDao.updateShop(shop);
}
public PageBean<Shop> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< Shop> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<Shop> list=shopDao.getlist(pageBean,key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=shopDao.getPageCount(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}
public Shop selectOne(Integer id) throws SQLException {
	return shopDao.selectOne(id);
}
public List<Shop> selectAll() throws SQLException {
	return shopDao.selectAll();
}
}

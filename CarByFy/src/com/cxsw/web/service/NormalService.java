package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cxsw.web.dao.NormalDao;
import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.util.PageBean;

public class NormalService {
NormalDao normalDao=new NormalDao();
public boolean addNormal(Admin admin) throws SQLException {
	return normalDao.addNormal(admin);
}
public boolean delNormal(Integer id) throws SQLException {
	return normalDao.delNormal(id);
}
public boolean updateNormal(Admin admin) throws SQLException {
	return normalDao.updateNormal(admin);
}
public PageBean<Admin> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< Admin> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<Admin> list=normalDao.getlist(pageBean,key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=normalDao.getPageCount(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}
public Admin selectOne(Integer id) throws SQLException {
	return normalDao.selectOne(id);
}
}

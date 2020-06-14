package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.TestDao;
import com.cxsw.web.pojo.Order;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.util.PageBean;

public class TestService {
TestDao testDao=new TestDao();
public boolean addTest(Test test) throws SQLException {
	return testDao.addTest(test);
}
public boolean delTest(Integer id) throws SQLException {
	return testDao.delTest(id);
}
public boolean updateTest(Test test) throws SQLException {
	return testDao.updateTest(test);
}
public PageBean<Test> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< Test> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<Test> list=testDao.getlist(pageBean,key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=testDao.getPageCount(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}
public Test selectOne(Integer id) throws SQLException {
	return testDao.selectOne(id);
}
public Test selectByNmae(String name) throws SQLException {
	return testDao.selectByNmae(name);
}

public PageBean<Test> selectByPhone(String phone) throws SQLException {
	return testDao.selectByPhone(phone);
}
public PageBean<Test> getPageBeanByNormal(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< Test> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<Test> list=testDao.getlistByNormal(pageBean, key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=testDao.getPageCountByNormal(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}


}

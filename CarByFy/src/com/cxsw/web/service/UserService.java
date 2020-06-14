package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cxsw.web.dao.UserDao;
import com.cxsw.web.pojo.User;
import com.cxsw.web.util.PageBean;

public class UserService {
UserDao userDao=new UserDao();

public boolean delNormal(Integer id) throws SQLException {
	return userDao.delUser(id);
}
public boolean updateUser(User user) throws SQLException {
	return userDao.updateUser(user);
}
public PageBean<User> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< User> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<User> list=userDao.getlist(pageBean,key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=userDao.getPageCount(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}
public User selectOne(Integer id) throws SQLException {
	return userDao.selectOne(id);
}
public boolean userAdd(User user) throws SQLException {
return userDao.userAdd(user);
}
public List<User> selectAll() throws SQLException {
	
	return userDao.selectAll();
	}
public List<User> selectPhone(String name) throws SQLException {
	return userDao.selectPhone(name);
}
}

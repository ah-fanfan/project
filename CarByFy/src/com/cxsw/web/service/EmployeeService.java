package com.cxsw.web.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cxsw.web.dao.EmployeeDao;
import com.cxsw.web.pojo.Employee;
import com.cxsw.web.util.PageBean;

public class EmployeeService {
EmployeeDao employeeDao=new EmployeeDao();
public boolean addEmployee(Employee employee) throws SQLException {
	return employeeDao.addEmployee(employee);
}
public boolean delEmployee(Integer id) throws SQLException {
	return employeeDao.delEmployee(id);
}
public boolean updateEmployee(Employee employee) throws SQLException {
	return employeeDao.updateEmployee(employee);
}
public PageBean<Employee> getPageBean(int pageNumber, int pageSize,String  key) throws SQLException {
	PageBean< Employee> pageBean=new PageBean<>(pageNumber, pageSize);
	//1.��ҳ��ʾ������  select * from car where c_staus=1  limit ?,? 
	List<Employee> list=employeeDao.getlist(pageBean,key);
	//2.���ж��������� select count(*) from managerlist 
	int pageCount=employeeDao.getPageCount(key);
	//3.���ж���ҳ   
	int totalPage=pageBean.getTotalPage();
	pageBean.setPageCount(pageCount);
	pageBean.setTotalPage(totalPage);
	pageBean.setList(list);
	return pageBean;
}
public Employee selectOne(Integer id) throws SQLException {
	return employeeDao.selectOne(id);
}
public List<Employee> selectAll() throws SQLException {
return employeeDao.selectAll();
}
}

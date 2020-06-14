package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.io.filefilter.FalseFileFilter;

import com.cxsw.web.pojo.Employee;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;

public class EmployeeDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql=null;
	public boolean addEmployee(Employee employee) throws SQLException {
		sql="insert into employee(emp_code,emp_name,emp_age,emp_sex,emp_dep,emp_phone,emp_idcard,emp_address,emp_img,comment,state)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,employee.getEmp_code(),employee.getEmp_name(),employee.getEmp_age(),employee.getEmp_sex(),employee.getEmp_dep(),employee.getEmp_phone(),employee.getEmp_idcard(),employee.getEmp_address(),employee.getEmp_img(),employee.getComment(),employee.getState());
		return res>0?true:false;
	}
	public boolean delEmployee(Integer id) throws SQLException {
		sql="delete from employee where id=? " ;
		int res=queryRunner.update(sql,id);
		return res>0?true:false;
	}
	public boolean updateEmployee(Employee employee) throws SQLException {
		sql="update employee set emp_code=?,emp_name=?,emp_age=?,emp_sex=?,emp_dep=?,emp_phone=?,emp_idcard=?,emp_address=?,emp_img=?,comment=?,state=? where id=? ";
		int res=queryRunner.update(sql,employee.getEmp_code(),employee.getEmp_name(),employee.getEmp_age(),employee.getEmp_sex(),employee.getEmp_dep(),employee.getEmp_phone(),employee.getEmp_idcard(),employee.getEmp_address(),employee.getEmp_img(),employee.getComment(),employee.getState(),employee.getId());
		return res>0?true:false;
	}
	
	public List<Employee> getlist(PageBean<Employee> pageBean,String key) throws SQLException{
		//List<Admin> CarMarkList=null;
		if(key == null || "".equals(key)) {
			sql="select * from employee  limit ?,?";
			List<Employee> list=queryRunner.query(sql, new BeanListHandler<>(Employee.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from employee  "
					+ "where  id LIKE '%"+key+"%' OR emp_code like '%"+key+"%' OR emp_name LIKE  '%"+key+"%' OR emp_age LIKE '%"+key+"%'"
							+ " OR emp_sex like '%"+key+"%' OR emp_dep like '%"+key+"%' OR emp_phone like '%"+key+"%' OR"
					+ " emp_idcard like '%"+key+"%' OR emp_address like '%"+key+"%' "
							+ " OR emp_img like '%"+key+"%' OR comment like '%"+key+"%'  OR state like '%"+key+"%' limit ?,?";
		}
		List<Employee> list=queryRunner.query(sql, new BeanListHandler<>(Employee.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from employee ";
		}else {
			sql="select count(*) from employee "
					+"where  id LIKE '%"+key+"%' OR emp_code like '%"+key+"%' OR emp_name LIKE  '%"+key+"%' OR emp_age LIKE '%"+key+"%'"
					+ " OR emp_sex like '%"+key+"%' OR emp_dep like '%"+key+"%' OR emp_phone like '%"+key+"%' OR"
		         	+ " emp_idcard like '%"+key+"%' OR emp_address like '%"+key+"%' "
					+ " OR emp_img like '%"+key+"%' OR comment like '%"+key+"%'  OR state like '%"+key+"%'";
		}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public Employee selectOne(Integer id) throws SQLException {
		sql="select * from employee where  id=?";
		Employee admin=queryRunner.query(sql,new BeanHandler<Employee>(Employee.class),id);
		return admin;
	}
	public List<Employee> selectAll() throws SQLException {
		sql="select * from employee where  emp_dep= 'œ˙ €≤ø'";
		List<Employee> list=queryRunner.query(sql,new BeanListHandler<Employee>(Employee.class));
		return list;
	}

}

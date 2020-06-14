package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.io.filefilter.FalseFileFilter;

import com.cxsw.web.pojo.Employee;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;

public class TestDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql=null;
	public boolean addTest(Test test) throws SQLException {
		sql="insert into test(t_code,user_phone,user_name,t_car,t_shop,t_date,t_normal,comment,state)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,test.getT_code(),test.getUser_phone(),test.getUser_name(),test.getT_car(),test.getT_shop(),test.getT_date(),test.getT_normal(),test.getComment(),test.getState());
		return res>0?true:false;
	}
	public boolean delTest(Integer id) throws SQLException {
		sql="delete from test where t_id=? " ;
		int res=queryRunner.update(sql,id);
		return res>0?true:false;
	}
	public boolean updateTest(Test test) throws SQLException {
		sql="update test set t_code=?,user_phone=?,user_name=?,t_car=?,t_shop=?,t_date=?,t_normal =?,comment=?,state=? where t_id=? ";
		int res=queryRunner.update(sql,test.getT_code(),test.getUser_phone(),test.getUser_name(),test.getT_car(),test.getT_shop(),test.getT_date(),test.getT_normal(),test.getComment(),test.getState(),test.getT_id());
		return res>0?true:false;
	}
	
	public List<Test> getlist(PageBean<Test> pageBean,String key) throws SQLException{
		//List<Admin> CarMarkList=null;
		if(key == null || "".equals(key)) {
			sql="select * from test  limit ?,?";
			List<Test> list=queryRunner.query(sql, new BeanListHandler<>(Test.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from test  "
					+ "where  t_id LIKE '%"+key+"%' OR t_code like '%"+key+"%' OR user_name LIKE  '%"+key+"%' OR user_phone LIKE '%"+key+"%'"
							+ " OR t_car like '%"+key+"%' OR t_shop like '%"+key+"%' OR t_date like '%"+key+"%' OR"
					+ " t_normal like '%"+key+"%' OR comment like '%"+key+"%' "
							+ " OR state like '%"+key+"%'  limit ?,?";
		}
		List<Test> list=queryRunner.query(sql, new BeanListHandler<>(Test.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	public List<Test> getlistByNormal(PageBean<Test> pageBean,String key) throws SQLException{
		//List<Admin> CarMarkList=null;

			sql="select * from test  "
					+ "where  t_normal = '"+key+"'  limit ?,?";
		
		List<Test> list=queryRunner.query(sql, new BeanListHandler<>(Test.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	public int getPageCountByNormal(String key) throws SQLException {
		
			sql="select count(*) from test "
					+ "where  t_normal = '"+key+"'";
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from test ";
		}else {
			sql="select count(*) from test "
					+ "where  t_id LIKE '%"+key+"%' OR t_code like '%"+key+"%' OR user_name LIKE  '%"+key+"%' OR user_phone LIKE '%"+key+"%'"
					+ " OR t_car like '%"+key+"%' OR t_shop like '%"+key+"%' OR t_date like '%"+key+"%' OR"
			+ " t_normal like '%"+key+"%' OR comment like '%"+key+"%' "
					+ " OR state like '%"+key+"%' ";
		}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public Test selectOne(Integer id) throws SQLException {
		sql="select * from test where  t_id=?";
		Test admin=queryRunner.query(sql,new BeanHandler<Test>(Test.class),id);
		return admin;
	}
	public Test selectByNmae(String name) throws SQLException {
		sql="select * from test where  user_name=? ";
		Test admin=queryRunner.query(sql,new BeanHandler<Test>(Test.class),name);
		return admin;
	}
	public PageBean<Test> selectByPhone(String phone) throws SQLException {
		String sql="select * from test where  user_phone=?";
		List<Test> admin=queryRunner.query(sql,new BeanListHandler<Test>(Test.class),phone);
		PageBean <Test> pageBean =new PageBean<Test>();
		pageBean.setList(admin);
		pageBean.setPageNumber(1);
		pageBean.setPageSize(6);
		return pageBean;
	}
}

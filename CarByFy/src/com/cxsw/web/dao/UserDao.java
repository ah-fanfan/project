package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.io.filefilter.FalseFileFilter;
import com.cxsw.web.pojo.User;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;

public class UserDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql=null;
	public boolean delUser(Integer id) throws SQLException {
		sql="delete from user where id=?" ;
		int res=queryRunner.update(sql,id);
		return res>0?true:false;
	}
	public boolean updateUser(User user) throws SQLException {
		sql="update user set user_name=?,user_psw=?,user_idcard=?,user_phone=?,user_age=?,user_sex=?,user_address=?,comment=?,state=? where id=? ";
		int res=queryRunner.update(sql,user.getUser_name(),user.getUser_psw(),user.getUser_idcard(),user.getUser_phone(),user.getUser_age(),user.getUser_sex(),user.getUser_address(),user.getComment(),user.getState(),user.getId());
		return res>0?true:false;
	}
	
	public List<User> getlist(PageBean<User> pageBean,String key) throws SQLException{
		//List<Admin> CarMarkList=null;
		if(key == null || "".equals(key)) {
			sql="select * from user limit ?,?";
			List<User> list=queryRunner.query(sql, new BeanListHandler<>(User.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from user  "
					+ "where  id LIKE '%"+key+"%' OR user_name like '%"+key+"%' OR user_psw LIKE  '%"+key+"%' OR user_idcard LIKE '%"+key+"%' OR user_phone like '%"+key+"%' OR user_sex like '%"+key+"%' OR user_address like '%"+key+"%' OR user_age like '%"+key+"%'   OR comment like '%"+key+"%'  OR state like '%"+key+"%' limit ?,?";
		}
		List<User> list=queryRunner.query(sql, new BeanListHandler<>(User.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from user";
		}else {
			sql="select count(*) from user "
					+"where  id LIKE '%"+key+"%' OR user_name like '%"+key+"%' OR user_psw LIKE  '%"+key+"%' OR user_idcard LIKE '%"+key+"%' OR user_phone like '%"+key+"%' OR user_sex like '%"+key+"%' OR user_address like '%"+key+"%' OR user_age like '%"+key+"%'   OR comment like '%"+key+"%'  OR state like '%"+key+"%'";
							}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public User selectOne(Integer id) throws SQLException {
		sql="select * from user where  id=?";
		User user=queryRunner.query(sql,new BeanHandler<User>(User.class),id);
		return user;
	}
	public boolean userAdd(User user) throws SQLException {
		sql="insert into USER(user_name,user_psw,user_idcard,user_phone,user_age,user_sex,user_address,COMMENT,state) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,user.getUser_name(),user.getUser_psw(),user.getUser_idcard(),user.getUser_phone(),user.getUser_age(),user.getUser_sex(),user.getUser_address(),user.getComment(),user.getState());
		return res>0?true:false;
	}
	public List<User> selectAll() throws SQLException {
		sql="select * from user where state=1";
		List<User>  list=queryRunner.query(sql, new BeanListHandler<>(User.class));
		return list;
	}
	public List<User> selectPhone(String name) throws SQLException {
	sql="select * from user where user_name=?";
	List<User> user=queryRunner.query(sql, new BeanListHandler<>(User.class),name);
		return user;
	}
}

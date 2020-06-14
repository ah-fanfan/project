package com.cxsw.web.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.User;
import com.cxsw.web.util.DataSourceUtils;

public class LoginDao {
	
	private QueryRunner query=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql;
	
	public Admin login(Admin admin) throws SQLException {
		sql="select * from admin where ad_code = ? and ad_psw = ?";
		Admin ad=query.query(sql, new BeanHandler<>(Admin.class),admin.getAd_code(),admin.getAd_psw());
		return ad;
	}
	public User login(User user) throws SQLException {
		sql="select * from user where user_phone = ? and user_psw = ?";
		User ad=query.query(sql, new BeanHandler<>(User.class),user.getUser_phone(),user.getUser_psw());
		return ad;
	}
	
	public boolean modifyPsw(String psw,String code) throws SQLException {
		sql="update  admin set ad_psw=? where ad_code=? ";
		int res=query.update(sql,psw,code);
		return res>0?true:false;
	}
	
}

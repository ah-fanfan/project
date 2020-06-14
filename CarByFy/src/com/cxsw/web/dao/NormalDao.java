package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.io.filefilter.FalseFileFilter;

import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;

public class NormalDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql=null;
	public boolean addNormal(Admin admin) throws SQLException {
		sql="insert into admin(ad_code,ad_psw,ad_power,ad_name,ad_age,ad_sex,ad_phone,ad_address,img,comment,state)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,admin.getAd_code(),admin.getAd_psw(),admin.getAd_power(),admin.getAd_name(),admin.getAd_age(),admin.getAd_sex(),admin.getAd_phone(),admin.getAd_address(),admin.getImg(),admin.getComment(),admin.getState());
		return res>0?true:false;
	}
	public boolean delNormal(Integer id) throws SQLException {
		sql="delete from admin where id=? and ad_power=2" ;
		int res=queryRunner.update(sql,id);
		return res>0?true:false;
	}
	public boolean updateNormal(Admin admin) throws SQLException {
		sql="update admin set ad_code=?,ad_psw=?,ad_power=?,ad_name=?,ad_age=?,ad_sex=?,ad_phone=?,ad_address=?,img=?,comment=?,state=? where id=? ";
		int res=queryRunner.update(sql,admin.getAd_code(),admin.getAd_psw(),admin.getAd_power(),admin.getAd_name(),admin.getAd_age(),admin.getAd_sex(),admin.getAd_phone(),admin.getAd_address(),admin.getImg(),admin.getComment(),admin.getState(),admin.getId());
		return res>0?true:false;
	}
	
	public List<Admin> getlist(PageBean<Admin> pageBean,String key) throws SQLException{
		//List<Admin> CarMarkList=null;
		if(key == null || "".equals(key)) {
			sql="select * from admin where ad_power=2 limit ?,?";
			List<Admin> list=queryRunner.query(sql, new BeanListHandler<>(Admin.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from admin  "
					+ "where ad_power=2 and id LIKE '%"+key+"%' OR ad_code like '%"+key+"%' OR ad_psw LIKE  '%"+key+"%' OR ad_name LIKE '%"+key+"%' OR ad_age like '%"+key+"%' OR ad_sex like '%"+key+"%' OR ad_phone like '%"+key+"%' OR ad_address like '%"+key+"%'  OR img like '%"+key+"%' OR comment like '%"+key+"%'  OR state like '%"+key+"%' limit ?,?";
		}
		List<Admin> list=queryRunner.query(sql, new BeanListHandler<>(Admin.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from admin where ad_power=2";
		}else {
			sql="select count(*) from admin "
					+"where ad_power=2 and id LIKE '%"+key+"%' OR ad_code like '%"+key+"%' OR ad_psw LIKE  '%"+key+"%' OR ad_name LIKE '%"+key+"%' OR ad_age like '%"+key+"%' OR ad_sex like '%"+key+"%' OR ad_phone like '%"+key+"%' OR ad_address like '%"+key+"%'  OR img like '%"+key+"%' OR comment like '%"+key+"%'  OR state like '%"+key+"%' ";
		}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public Admin selectOne(Integer id) throws SQLException {
		sql="select * from admin where ad_power=2 and id=?";
		Admin admin=queryRunner.query(sql,new BeanHandler<Admin>(Admin.class),id);
		return admin;
	}

}

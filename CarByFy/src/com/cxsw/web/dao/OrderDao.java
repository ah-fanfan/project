package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import com.cxsw.web.pojo.Order;
import com.cxsw.web.pojo.Test;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;
import com.mysql.jdbc.StreamingNotifiable;


public class OrderDao {
	QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql;


	public Order  selectOne(Integer id) throws SQLException {
		sql="select * from carorder where id = ?";
		Order order=queryRunner.query(sql, new BeanHandler<Order>(Order.class),id);
		return order;
	}
	
	public List<Order> getlist(PageBean<Order> pageBean,String key) throws SQLException{
		if(key == null || "".equals(key)) {
			sql="select * from carorder limit ?,?";
			List<Order> list=queryRunner.query(sql, new BeanListHandler<>(Order.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from carorder  "
					+ "where id LIKE '%"+key+"%' OR car_id LIKE '%"+key+"%' OR car_code LIKE '%"+key+"%' OR user_idcard LIKE  '%"+key+"%' OR user_name LIKE '%"+key+"%' "
							+ "   OR fetch_time like '%"+key+"%'  OR price like '%"+key+"%' OR order_code like '%"+key+"%' OR comment like '%"+key+"%'"
								+" OR state like '%"+key+"%' OR car_name like '%"+key+"%'  limit ?,?";
		}
		List<Order> list=queryRunner.query(sql, new BeanListHandler<>(Order.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	public List<Order> getlistByIdCard(PageBean<Order> pageBean,String key) throws SQLException{
	

			sql="select * from carorder  "
					+ "where  user_idcard = '"+key+"'   limit ?,?";
		List<Order> list=queryRunner.query(sql, new BeanListHandler<>(Order.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	public int getPageCountByIdCard(String key) throws SQLException {
			sql="select count(*) from carorder "
					+  "where  user_idcard = '"+key+"' ";
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from carorder";
		}else {
			sql="select count(*) from carorder "
					+ "where id LIKE '%"+key+"%'  OR car_id LIKE '%"+key+"%' OR car_code LIKE '%"+key+"%' OR user_idcard LIKE  '%"+key+"%' OR user_name LIKE '%"+key+"%'  "
					+ "  OR fetch_time like '%"+key+"%'  OR price like '%"+key+"%' OR order_code like '%"+key+"%' OR comment like '%"+key+"%'"
						+" OR state like '%"+key+"%' OR car_name like '%"+key+"%' ";
		}
		int pageCount=  ((Long)queryRunner.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	public boolean addOrder(Order order) throws SQLException {
		sql="insert into carorder(user_idcard,user_name,car_id,car_code,car_name,shop_name,fetch_time,price,order_code,COMMENT,state)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		int res=queryRunner.update(sql,order.getUser_idcard(),order.getUser_name(),order.getCar_id(),order.getCar_code(),order.getCar_name(),order.getShop_name(),order.getFetch_time(),order.getPrice(),order.getOrder_code(),order.getComment(),order.getState());
		int res1;
		if(res>0) {
			sql="update car_info set comment=comment-1 where id=?";
			res1=queryRunner.update(sql,order.getCar_id());
		}else {
			return false;
		}
		
		
		return res>0&&res1>0?true:false;
	}
	  public boolean orderDel(Integer id) throws SQLException {
	    	sql="delete from carorder where id=?";
	    	int res=queryRunner.update(sql,id);
	    	return res>0?true:false;
	    }
	

}

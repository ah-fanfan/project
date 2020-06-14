package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.io.filefilter.FalseFileFilter;
import com.cxsw.web.pojo.Shop;
import com.cxsw.web.util.DataSourceUtils;
import com.cxsw.web.util.PageBean;

public class ShopDao {
	QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	private String sql = null;

	public boolean addShop(Shop shop) throws SQLException {
		sql = "insert into shop(province,city,country,detail_address,name,img,comment,state) values(?,?,?,?,?,?,?,?)";
		int res = queryRunner.update(sql, shop.getProvince(), shop.getCity(), shop.getCountry(),
				shop.getDetail_address(), shop.getName(), shop.getImg(), shop.getComment(), shop.getState());
		return res > 0 ? true : false;
	}

	public boolean delShop(Integer id) throws SQLException {
		sql = "delete from shop where id=? ";
		int res = queryRunner.update(sql, id);
		return res > 0 ? true : false;
	}

	public boolean updateShop(Shop shop) throws SQLException {
		sql = "update shop set province=?,city=?,country=?,detail_address=?,name=?,img=?,comment=?,state=? where id=? ";
		int res = queryRunner.update(sql, shop.getProvince(), shop.getCity(), shop.getCountry(),
				shop.getDetail_address(), shop.getName(), shop.getImg(), shop.getComment(), shop.getState(), shop.getId());
		return res > 0 ? true : false;
	}

	public List<Shop> getlist(PageBean<Shop> pageBean, String key) throws SQLException {
		if (key == null || "".equals(key)) {
			sql = "select * from shop  limit ?,?";
			List<Shop> list = queryRunner.query(sql, new BeanListHandler<>(Shop.class), pageBean.getIndex(),pageBean.getPageSize());
			return list;
		} else {
			sql = "select * from shop  " + "  where id LIKE '%" + key + "%' OR province like '%" + key
					+ "%' OR city LIKE  '%" + key + "%' OR country LIKE '%" + key + "%' OR detail_address like '%" + key
					+ "%' OR name like '%" + key + "%' OR img like '%" + key + "%' OR comment like '%" + key
					+ "%'  OR state like '%" + key + "%'  limit ?,?";
		}
		List<Shop> list = queryRunner.query(sql, new BeanListHandler<>(Shop.class), pageBean.getIndex(),pageBean.getPageSize());
				
		return list;
	}

	public int getPageCount(String key) throws SQLException {
		if (key == null || "".equals(key)) {
			sql = "select count(*) from shop";
		} else {
			sql =  "select count(*) from shop  " + "where   id LIKE '%" + key + "%' OR province like '%" + key
					+ "%' OR city LIKE  '%" + key + "%' OR country LIKE '%" + key + "%' OR detail_address like '%" + key
					+ "%' OR name like '%" + key + "%' OR img like '%" + key + "%' OR comment like '%" + key
					+ "%'  OR state like '%" + key + "%'  ";
		}
		int pageCount = ((Long) queryRunner.query(sql, new ScalarHandler())).intValue();
		return pageCount;
	}

	public Shop selectOne(Integer id) throws SQLException {
		sql = "select * from shop where  id=?";
		Shop shop = queryRunner.query(sql, new BeanHandler<Shop>(Shop.class), id);
		return shop;
	}
	
	public List<Shop> selectAll() throws SQLException {
		sql = "select * from shop ";
		List<Shop> shopList= queryRunner.query(sql, new BeanListHandler<Shop>(Shop.class));
		return shopList;
	}

}

package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cxsw.web.pojo.CarKind;
import com.cxsw.web.util.DataSourceUtils;

import com.cxsw.web.util.PageBean;

public class CarKindDao {
	
	private QueryRunner query=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql;
	public boolean updateOne(CarKind carKind) throws SQLException {
		sql="update carkind set kind_name=?,comment=?,state=? where id=?";
		int res=query.update(sql,carKind.getKind_name(),carKind.getComment(),carKind.getState(),carKind.getId());
		return res>0?true:false;
	}

	public CarKind  selectOne(Integer id) throws SQLException {
		sql="select * from carkind where id = ?";
		CarKind carKind=query.query(sql, new BeanHandler<CarKind>(CarKind.class),id);
		return carKind;
	}
	
	public List<CarKind>  selectAll() throws SQLException {
		sql="select * from carkind";
		 List<CarKind> carKind=query.query(sql, new BeanListHandler<CarKind>(CarKind.class));
		return carKind;
	}
	
	
	

	public List<CarKind> getlist(PageBean<CarKind> pageBean,String key) throws SQLException{
		List<CarKind> carkindList=null;
		if(key == null || "".equals(key)) {
			sql="select * from carkind limit ?,?";
			List<CarKind> list=query.query(sql, new BeanListHandler<>(CarKind.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from carkind  "
					+ "where id LIKE '%"+key+"%' OR kind_name LIKE  '%"+key+"%' OR comment LIKE '%"+key+"%' OR state like '%"+key+"%' limit ?,?";
		}
		List<CarKind> list=query.query(sql, new BeanListHandler<>(CarKind.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from carkind";
		}else {
			sql="select count(*) from carkind "
					+ "where id LIKE '%"+key+"%' OR kind_name LIKE  '%"+key+"%' OR comment LIKE '%"+key+"%' OR state like '%"+key+"%'";
		}
		int pageCount=  ((Long)query.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	
    /** * @Title: addCarKind
        * @Description: 车型信息添加
        * @param @param carKind
        * @param @return
        * @param @throws SQLException    设定文件
        * @return boolean    返回类型
        * @throws */
    public boolean addCarKind(CarKind carKind) throws SQLException {
    	sql="insert into carkind(kind_name,comment,state) values (?,?,?)";
    	int res=query.update(sql,carKind.getKind_name(),carKind.getComment(),carKind.getState());
    	return res>0?true:false;
		
	}
    /** * @Title: carKindDel
        * @Description: 车型信息删除
        * @param @param id
        * @param @return
        * @param @throws SQLException    设定文件
        * @return boolean    返回类型
        * @throws */
    public boolean carKindDel(Integer id) throws SQLException {
    	sql="delete from carkind where id=?";
    	int res=query.update(sql,id);
    	return res>0?true:false;
    }

}

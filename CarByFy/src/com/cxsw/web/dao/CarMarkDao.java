package com.cxsw.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.cxsw.web.pojo.CarMark;
import com.cxsw.web.util.DataSourceUtils;

import com.cxsw.web.util.PageBean;

public class CarMarkDao {
	
	private QueryRunner query=new QueryRunner(DataSourceUtils.getDataSource());
	private String sql;
	public boolean updateOne(CarMark carMark) throws SQLException {
		sql="update CarMark set car_mark=?,img=?,comment=?,state=? where id=?";
		int res=query.update(sql,carMark.getCar_mark(),carMark.getImg(),carMark.getComment(),carMark.getState(),carMark.getId());
		return res>0?true:false;
	}

	public CarMark  selectOne(Integer id) throws SQLException {
		sql="select * from CarMark where id = ?";
		CarMark CarMark=query.query(sql, new BeanHandler<CarMark>(CarMark.class),id);
		return CarMark;
	}
	public List<CarMark>  selectAll() throws SQLException {
		sql="select * from CarMark ";
		List<CarMark>  c=query.query(sql, new BeanListHandler<CarMark>(CarMark.class));
		return c;
	}
	
	
	

	public List<CarMark> getlist(PageBean<CarMark> pageBean,String key) throws SQLException{
		List<CarMark> CarMarkList=null;
		if(key == null || "".equals(key)) {
			sql="select * from CarMark limit ?,?";
			List<CarMark> list=query.query(sql, new BeanListHandler<>(CarMark.class),pageBean.getIndex(),pageBean.getPageSize());
			return list;
		}else {
			sql="select * from CarMark  "
					+ "where id LIKE '%"+key+"%' OR img like '%"+key+"%' OR car_mark LIKE  '%"+key+"%' OR comment LIKE '%"+key+"%' OR state like '%"+key+"%' limit ?,?";
		}
		List<CarMark> list=query.query(sql, new BeanListHandler<>(CarMark.class),pageBean.getIndex(),pageBean.getPageSize());
		return list;
	}
	
	
	public int getPageCount(String key) throws SQLException {
		if(key == null || "".equals(key)) {
			sql="select count(*) from CarMark";
		}else {
			sql="select count(*) from CarMark "
					+ "where id LIKE '%"+key+"%' OR car_mark LIKE  '%"+key+"%' OR img LIKE  '%"+key+"%' OR comment LIKE '%"+key+"%' OR state like '%"+key+"%'";
		}
		int pageCount=  ((Long)query.query(sql,new ScalarHandler())).intValue();
		return pageCount;
	}
	
    /** * @Title: addCarMark
        * @Description: 品牌信息添加
        * @param @param CarMark
        * @param @return
        * @param @throws SQLException    设定文件
        * @return boolean    返回类型
        * @throws */
    public boolean addCarMark(CarMark carMark) throws SQLException {
    	sql="insert into CarMark(car_mark,img,comment,state) values (?,?,?,?)";
    	int res=query.update(sql,carMark.getCar_mark(),carMark.getImg(),carMark.getComment(),carMark.getState());
    	return res>0?true:false;
		
	}
    /** * @Title: CarMarkDel
        * @Description: 品牌信息删除
        * @param @param id
        * @param @return
        * @param @throws SQLException    设定文件
        * @return boolean    返回类型
        * @throws */
    public boolean CarMarkDel(Integer id) throws SQLException {
    	sql="delete from CarMark where id=?";
    	int res=query.update(sql,id);
    	return res>0?true:false;
    }

}

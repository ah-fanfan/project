package dsms1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtil {
	private  String url = "jdbc:mysql://localhost:3306/drivingschoolmanagementsystem";
	private  String user = "root";
	private  String psw = "root";
	private  Connection conn = null;
	private  PreparedStatement ps = null;
	private  ResultSet rs = null;
	
	//1、加载驱动
	static{//静态代码块：类的字节码文件第一次加载到内存的时候执行。
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动出现异常");
			e.printStackTrace();
		}
	}
	
	//2、提供获取连接的方法
	private  Connection getConn(){
		try {
			Connection conn=DriverManager.getConnection(url, user, psw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//3、提供释放资源的方法
	private  void release(){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//4、提供更新的方法
	public  int update(String sql,Object... objs){
		conn=getConn();
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			release();
		}
		return -1;
	}
	//5、查询的方法
	public  List<Map<String,Object>> query(String sql,Object... objs){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		conn=getConn();
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeQuery();
			//结果集结构化对象：获取结果集的信息(获取字段的个数、每个字段)
			ResultSetMetaData rsmd=rs.getMetaData();
			//将rs中的数据转存到数据结构中  将数据结构返回
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				//将当前行存储到Map中
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String key = rsmd.getColumnName(i);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
				//将当前Map存储到list中
				list.add(map);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release();
		}
		return null;
	}
}

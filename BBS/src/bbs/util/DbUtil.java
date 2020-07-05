package bbs.util;

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
	private  String url = "jdbc:mysql://localhost:3306/bbs";
	private  String user = "root";
	private  String psw = "root";
	private  Connection conn = null;
	private  PreparedStatement ps = null;
	private  ResultSet rs = null;
	
	//1����������
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//2���ṩ��ȡ���ӵķ���
	private  Connection getConn(){
		try {
			Connection conn=DriverManager.getConnection(url, user, psw);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//3���ṩ�ͷ���Դ�ķ���
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
	//4���ṩ���µķ���
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
	//5����ѯ�ķ���
	public  List<Map<String,Object>> query(String sql,Object... objs){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		conn=getConn();
		try {
			ps = conn.prepareStatement(sql);
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeQuery();
			//������ṹ�����󣺻�ȡ���������Ϣ(��ȡ�ֶεĸ�����ÿ���ֶ�)
			ResultSetMetaData rsmd=rs.getMetaData();
			//��rs�е�����ת�浽���ݽṹ��  �����ݽṹ����
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				//����ǰ�д洢��Map��
				for(int i=1;i<=rsmd.getColumnCount();i++){
					String key = rsmd.getColumnName(i);
					Object value = rs.getObject(key);
					map.put(key, value);
				}
				//����ǰMap�洢��list��
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

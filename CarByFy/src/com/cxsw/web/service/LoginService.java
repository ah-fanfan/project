package com.cxsw.web.service;

import java.sql.SQLException;

import com.cxsw.web.dao.LoginDao;
import com.cxsw.web.pojo.Admin;
import com.cxsw.web.pojo.User;

public class LoginService {
	private LoginDao loginDao=new LoginDao();
	
	public Admin login(Admin admin) throws SQLException {
		return loginDao.login(admin);
	}
	public User login(User user) throws SQLException {
		return loginDao.login(user);
	}
	public boolean modifyPsw(String psw,String code) throws SQLException {
	
		return loginDao.modifyPsw(psw, code);
	}

}

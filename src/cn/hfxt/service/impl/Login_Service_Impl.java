package cn.hfxt.service.impl;


import cn.hfxt.dao.LoginDao;
import cn.hfxt.dao.impl.LoginDaoImpl;
import cn.hfxt.entity.smbms_user;
import cn.hfxt.service.Login_Service;

public class Login_Service_Impl implements Login_Service{
	LoginDao login=new LoginDaoImpl();
	//µÇÂ¼
	@Override
	public smbms_user login(String userString, String pwdString) {
		// TODO Auto-generated method stub
		return login.login(userString, pwdString);
	}
	
}

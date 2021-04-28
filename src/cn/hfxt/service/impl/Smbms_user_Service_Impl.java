package cn.hfxt.service.impl;

import java.util.List;


import cn.hfxt.dao.UserDao;
import cn.hfxt.dao.impl.UserDaoImpl;
import cn.hfxt.entity.smbms_user;
import cn.hfxt.service.Smbms_user_Service;

public class Smbms_user_Service_Impl implements Smbms_user_Service{
private UserDao uDao=new UserDaoImpl();
	
	@Override
	public List<smbms_user> sele(int begin, int size) {
		// TODO Auto-generated method stub
		return uDao.sele(begin, size);
	}

	@Override
	public List<smbms_user> seleAll() {
		// TODO Auto-generated method stub
		return uDao.seleAll();
	}
	
}

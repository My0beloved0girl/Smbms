package cn.hfxt.dao.impl;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.LoginDao;
import cn.hfxt.entity.smbms_user;

public class LoginDaoImpl extends BaseDao implements LoginDao{
	//µÇÂ¼
	@Override
	public smbms_user login(String userString, String pwdString) {
		String sql="SELECT * FROM smbms_user where usercode=? and userpassword=?";
		smbms_user queryForOne= queryForOne(smbms_user.class,sql,userString,pwdString);
		return queryForOne;
	}
	
}

package cn.hfxt.dao;

import cn.hfxt.entity.smbms_user;

public interface LoginDao {
	public smbms_user login(String userString,String pwdString);
}

package cn.hfxt.service;

import cn.hfxt.entity.smbms_user;

public interface Login_Service {
	public smbms_user login(String userString,String pwdString);
}

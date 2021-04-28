package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.smbms_user;

public interface Smbms_user_Service {
//	≤È—Ø
	public List<smbms_user> sele(int begin,int size);
	
	public List<smbms_user> seleAll();
}

package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.smbms_user;

public interface UserDao {
//	查询
	public List<smbms_user> sele(int begin,int size);
//	查询总记录数
	public int seleCount();
	public List<smbms_user> seleAll();
}

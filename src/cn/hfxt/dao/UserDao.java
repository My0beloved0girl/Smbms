package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.smbms_user;

public interface UserDao {
//	��ѯ
	public List<smbms_user> sele(int begin,int size);
//	��ѯ�ܼ�¼��
	public int seleCount();
	public List<smbms_user> seleAll();
}

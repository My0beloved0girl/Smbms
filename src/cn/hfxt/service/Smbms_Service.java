package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_bill_page;
import cn.hfxt.entity.smbms_zd;

public interface Smbms_Service {
//	查询所有
	public List<smbms_zd> SeleAll(int begin,int size);
//	查询数量
	public int SeleCount();
//	删除
	public int del(int id);
//	增加
	public int inse(smbms_bill sb);
//	修改
	public int upda(smbms_bill sb);
//	id查询
	public List<smbms_bill> seleid(int id);
//	模糊查询（根据名称查询）
	public List<smbms_zd> selename(String name);
}


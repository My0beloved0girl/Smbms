package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.smbms_provider;

public interface Smbms_provider_Service {
//	下拉框查询
	public List<smbms_provider> sele();
//  查询所有
	public List<smbms_provider> seleall(int begin,int size);
//	查询总记录数
	public int SeleCount();
//	供应商名称查询
	public List<smbms_provider> seleProName(String name);
}

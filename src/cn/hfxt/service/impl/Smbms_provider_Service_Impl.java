package cn.hfxt.service.impl;

import java.util.List;

import cn.hfxt.dao.Smbms_provider_Dao;
import cn.hfxt.dao.impl.Smbms_provider_Dao_Impl;
import cn.hfxt.entity.smbms_provider;
import cn.hfxt.service.Smbms_provider_Service;

public class Smbms_provider_Service_Impl implements Smbms_provider_Service{
	Smbms_provider_Dao spd=new Smbms_provider_Dao_Impl();
//	下拉框查询数据
	@Override
	public List<smbms_provider> sele() {
		// TODO Auto-generated method stub
		return spd.sele();
	}
//	分页查询所有数据
	@Override
	public List<smbms_provider> seleall(int begin, int size) {
		// TODO Auto-generated method stub
		return spd.seleall(begin, size);
	}
//	查询总记录数
	@Override
	public int SeleCount() {
		// TODO Auto-generated method stub
		return spd.SeleCount();
	}
//	供应商名称查询
	@Override
	public List<smbms_provider> seleProName(String name) {
		// TODO Auto-generated method stub
		return spd.seleProName(name);
	}
	
}

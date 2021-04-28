package cn.hfxt.service.impl;

import java.util.List;

import cn.hfxt.dao.Smbms_Dao;
import cn.hfxt.dao.impl.smbms_Dao_Impl;
import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_bill_page;
import cn.hfxt.entity.smbms_zd;
import cn.hfxt.service.Smbms_Service;
import cn.hfxt.servlet.Smbms_bill_Servlet;

public class Smbms_Service_Impl implements Smbms_Service{
Smbms_Dao smbmsdao=new smbms_Dao_Impl();
//  查询
	@Override
	public List<smbms_zd> SeleAll(int begin,int size) {
		// TODO Auto-generated method stub
		return smbmsdao.SeleAll(begin, size);
	}
//	查询所有
	@Override
	public int SeleCount() {
		// TODO Auto-generated method stub
		return smbmsdao.SeleCount();
	}
//	删除
	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return smbmsdao.del(id);
	}
//	增加
	@Override
	public int inse(smbms_bill sb) {
		// TODO Auto-generated method stub
		return smbmsdao.inse(sb);
	}
//	修改
	@Override
	public int upda(smbms_bill sb) {
		// TODO Auto-generated method stub
		return smbmsdao.upda(sb);
	}
//	id查询
	@Override
	public List<smbms_bill> seleid(int id) {
		// TODO Auto-generated method stub
		return smbmsdao.seleid(id);
	}
//	模糊查询（根据名称）
	@Override
	public List<smbms_zd> selename(String name) {
		// TODO Auto-generated method stub
		return smbmsdao.selename(name);
	}
	
}

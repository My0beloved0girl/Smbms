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
//  ��ѯ
	@Override
	public List<smbms_zd> SeleAll(int begin,int size) {
		// TODO Auto-generated method stub
		return smbmsdao.SeleAll(begin, size);
	}
//	��ѯ����
	@Override
	public int SeleCount() {
		// TODO Auto-generated method stub
		return smbmsdao.SeleCount();
	}
//	ɾ��
	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return smbmsdao.del(id);
	}
//	����
	@Override
	public int inse(smbms_bill sb) {
		// TODO Auto-generated method stub
		return smbmsdao.inse(sb);
	}
//	�޸�
	@Override
	public int upda(smbms_bill sb) {
		// TODO Auto-generated method stub
		return smbmsdao.upda(sb);
	}
//	id��ѯ
	@Override
	public List<smbms_bill> seleid(int id) {
		// TODO Auto-generated method stub
		return smbmsdao.seleid(id);
	}
//	ģ����ѯ���������ƣ�
	@Override
	public List<smbms_zd> selename(String name) {
		// TODO Auto-generated method stub
		return smbmsdao.selename(name);
	}
	
}

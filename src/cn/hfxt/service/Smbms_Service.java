package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_bill_page;
import cn.hfxt.entity.smbms_zd;

public interface Smbms_Service {
//	��ѯ����
	public List<smbms_zd> SeleAll(int begin,int size);
//	��ѯ����
	public int SeleCount();
//	ɾ��
	public int del(int id);
//	����
	public int inse(smbms_bill sb);
//	�޸�
	public int upda(smbms_bill sb);
//	id��ѯ
	public List<smbms_bill> seleid(int id);
//	ģ����ѯ���������Ʋ�ѯ��
	public List<smbms_zd> selename(String name);
}


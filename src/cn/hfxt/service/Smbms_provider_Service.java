package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.smbms_provider;

public interface Smbms_provider_Service {
//	�������ѯ
	public List<smbms_provider> sele();
//  ��ѯ����
	public List<smbms_provider> seleall(int begin,int size);
//	��ѯ�ܼ�¼��
	public int SeleCount();
//	��Ӧ�����Ʋ�ѯ
	public List<smbms_provider> seleProName(String name);
}

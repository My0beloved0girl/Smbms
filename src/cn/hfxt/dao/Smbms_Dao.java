package cn.hfxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_zd;

public interface Smbms_Dao {
//	��ѯ����
	public List<smbms_zd> SeleAll(@Param("pageNo")int begin,@Param("pageSize")int size);
//	id��ѯ
	public List<smbms_bill> seleid(int id);
//	��ѯ�ܼ�¼��
	public int SeleCount();
//	ɾ��
	public int del(int id);
//	���
	public int inse(smbms_bill sb);
//	�޸�
	public int upda(smbms_bill sb);
//	ģ����ѯ���������Ʋ�ѯ��
	public List<smbms_zd> selename(String name);
	
	
}

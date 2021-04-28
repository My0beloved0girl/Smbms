package cn.hfxt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_zd;

public interface Smbms_Dao {
//	查询所有
	public List<smbms_zd> SeleAll(@Param("pageNo")int begin,@Param("pageSize")int size);
//	id查询
	public List<smbms_bill> seleid(int id);
//	查询总记录数
	public int SeleCount();
//	删除
	public int del(int id);
//	添加
	public int inse(smbms_bill sb);
//	修改
	public int upda(smbms_bill sb);
//	模糊查询（根据名称查询）
	public List<smbms_zd> selename(String name);
	
	
}

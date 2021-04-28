package cn.hfxt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.Smbms_provider_Dao;
import cn.hfxt.entity.smbms_provider;
import cn.hfxt.entity.smbms_provider_page;

public class Smbms_provider_Dao_Impl extends BaseDao implements Smbms_provider_Dao{
//	下拉框查询
	@Override
	public List<smbms_provider> sele() {
		conn=getConnection();
		List<smbms_provider> list=new ArrayList<smbms_provider>();
		String sql="select id,proName from smbms_provider";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_provider sp=new smbms_provider();
				sp.setId(rs.getInt(1));
				sp.setProName(rs.getString(2));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
//	分页查询
	@Override
	public List<smbms_provider> seleall(int begin,int size) {
		conn=getConnection();
		List<smbms_provider> list=new ArrayList<smbms_provider>();
		String sql="SELECT id,proCode,proName,proContact,proPhone,proFax,creationDate FROM `smbms_provider` LIMIT ?,?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, (begin-1)*size);
			pre.setInt(2, size);
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_provider sp=new smbms_provider();
				sp.setId(rs.getInt("id"));
				sp.setProCode(rs.getString("proCode"));
				sp.setProName(rs.getString("proName"));
				sp.setProContact(rs.getString("proContact"));
				sp.setProPhone(rs.getString("proPhone"));
				sp.setProFax(rs.getString("proFax"));
				sp.setCreationDate(rs.getDate("creationDate"));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
//	查询总记录数
	@Override
	public int SeleCount() {
		String sql="select count(*) as num from `smbms_provider`";
		return getTotalCount(sql);
	}
//	供应商名称查询
	@Override
	public List<smbms_provider> seleProName(String name) {
		conn=getConnection();
		List<smbms_provider> list=new ArrayList<smbms_provider>();
		String sql="SELECT id,proCode,proName,proContact,proPhone,proFax,creationDate FROM `smbms_provider` WHERE proName LIKE '%?%' LIMIT ?,?";
		smbms_provider_page spp=new smbms_provider_page();
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setInt(2, (spp.getPageNo()-1)*spp.getPageSize());
			pre.setInt(3, spp.getPageSize());
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_provider sp=new smbms_provider();
				sp.setId(rs.getInt("id"));
				sp.setProCode(rs.getString("proCode"));
				sp.setProName(rs.getString("proName"));
				sp.setProContact(rs.getString("proContact"));
				sp.setProPhone(rs.getString("proPhone"));
				sp.setProFax(rs.getString("proFax"));
				sp.setCreationDate(rs.getDate("creationDate"));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

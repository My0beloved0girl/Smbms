package cn.hfxt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.UserDao;
import cn.hfxt.entity.smbms_user;
import cn.hfxt.entity.smbms_zd;

public class UserDaoImpl extends BaseDao implements UserDao{
//	≤È—Ø
	@Override
	public List<smbms_user> sele(int begin,int size) {
		conn=getConnection();
		List<smbms_user> list=new ArrayList<smbms_user>();
		String sql="select * from smbms_user";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, (begin-1)*size);
			pre.setInt(2, size);
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_user sUser=new smbms_user();
				sUser.setId(rs.getInt(1));
				sUser.setUserCode(rs.getString(2));
				sUser.setUserName(rs.getString(3));
				sUser.setUserPassword(rs.getString(4));
				sUser.setGender(rs.getInt(5));
				sUser.setBirthday(rs.getDate(6));
				sUser.setPhone(rs.getString(7));
				sUser.setAddress(rs.getString(8));
				sUser.setUserrole(rs.getInt(9));
				sUser.setCreatedBy(rs.getInt(10));
				sUser.setCreationDate(rs.getDate(11));
				sUser.setModifyBy(rs.getInt(12));
				sUser.setModifyDate(rs.getDate(13));
				list.add(sUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int seleCount() {
		String sql="select ";
		return 0;
	}

	@Override
	public List<smbms_user> seleAll() {
		conn=getConnection();
		List<smbms_user> list=new ArrayList<smbms_user>();
		String sql="select * from smbms_user";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_user sUser=new smbms_user();
				sUser.setId(rs.getInt(1));
				sUser.setUserCode(rs.getString(2));
				sUser.setUserName(rs.getString(3));
				sUser.setUserPassword(rs.getString(4));
				sUser.setGender(rs.getInt(5));
				sUser.setBirthday(rs.getDate(6));
				sUser.setPhone(rs.getString(7));
				sUser.setAddress(rs.getString(8));
				sUser.setUserrole(rs.getInt(9));
				sUser.setCreatedBy(rs.getInt(10));
				sUser.setCreationDate(rs.getDate(11));
				sUser.setModifyBy(rs.getInt(12));
				sUser.setModifyDate(rs.getDate(13));
				list.add(sUser);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}

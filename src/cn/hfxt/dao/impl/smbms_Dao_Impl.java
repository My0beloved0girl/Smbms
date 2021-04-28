package cn.hfxt.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.hfxt.entity.smbms_bill;
import cn.hfxt.entity.smbms_bill_page;
import cn.hfxt.entity.smbms_zd;
import cn.hfxt.utils.MyBatisUtil;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.Smbms_Dao;

public class smbms_Dao_Impl extends BaseDao implements Smbms_Dao{
//	分页查询所有
	@Override
	public List<smbms_zd> SeleAll(int begin,int size) {
		List<smbms_zd> list=new ArrayList<smbms_zd>();
		SqlSession sqlSession = MyBatisUtil.createSqlSession();
		try {
			list = sqlSession.getMapper(Smbms_Dao.class).SeleAll((begin-1)*size, size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		System.out.println(list.size());
		return list;
	}
//  查询总记录数
	@Override
	public int SeleCount() {
		SqlSession sqlSession = MyBatisUtil.createSqlSession();
		return sqlSession.getMapper(Smbms_Dao.class).SeleCount();
	}
//	删除
	@Override
	public int del(int id) {
		String sql="delete from `smbms_bill` where id=?";
		return Operaction(sql, id);
	}
//	增加
	@Override
	public int inse(smbms_bill sb) {
		String sql="INSERT INTO `smbms_bill`(billCode,productName,productUnit,productCount,totalPrice,isPayment,createdBy,creationDate,providerId) VALUES(?,?,?,?,?,?,?,?,?)";
		return Operaction(sql, sb.getBillCode(),sb.getProductName(),sb.getProductUnit(),sb.getProductCount(),sb.getTotalPrice(),sb.getIsPayment(),sb.getCreatedBy(),sb.getCreationDate(),sb.getProviderId());
	}
//	id查询
	@Override
	public List<smbms_bill> seleid(int id) {
		conn=getConnection();
		String sql="select billCode,productName,productUnit,productCount,totalPrice,isPayment,createdBy,creationDate,providerId,id from `smbms_bill` where id=?";
		List<smbms_bill> list=new ArrayList<smbms_bill>();
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, id);
			rs=pre.executeQuery();
			while(rs.next()){
				smbms_bill sb=new smbms_bill();
				sb.setBillCode(rs.getString(1));
				sb.setProductName(rs.getString(2));
				sb.setProductUnit(rs.getString(3));
				sb.setProductCount(rs.getDouble(4));
				sb.setTotalPrice(rs.getDouble(5));
				sb.setIsPayment(rs.getInt(6));
				sb.setCreatedBy(rs.getInt(7));
				sb.setCreationDate(rs.getDate(8));
				sb.setProviderId(rs.getInt(9));
				sb.setId(rs.getInt(10));
				list.add(sb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
//	修改
	@Override
	public int upda(smbms_bill sb) {
		String sql="update `smbms_bill` set billCode=?,productName=?,productUnit=?,productCount=?,totalPrice=?,isPayment=?,providerId=? where id=?";
		return Operaction(sql, sb.getBillCode(),sb.getProductName(),sb.getProductUnit(),sb.getProductCount(),sb.getTotalPrice(),sb.getIsPayment(),sb.getProviderId(),sb.getId());
	}
//	模糊查询（根据名称）
	@Override
	public List<smbms_zd> selename(String name) {
		conn=getConnection();
		String sql="SELECT `smbms_bill`.`billCode`,`smbms_bill`.`productName`,`smbms_provider`.`proName`,`smbms_bill`.`totalPrice`,`smbms_bill`.`isPayment`,`smbms_bill`.`creationDate`,`smbms_bill`.id FROM `smbms_bill`,`smbms_provider` WHERE `smbms_bill`.providerId=`smbms_provider`.`id` AND productName=? LIMIT ?,?";
		List<smbms_zd> list=new ArrayList<smbms_zd>();
		smbms_bill_page sbp=new smbms_bill_page();
		try {
			pre=conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setInt(2, (sbp.getPageNo()-1)*sbp.getPageSize());
			pre.setInt(3, sbp.getPageSize());
			rs=pre.executeQuery();
			while (rs.next()) {
				smbms_zd sz=new smbms_zd();
				sz.setId(rs.getInt(7));
				sz.setBillCode(rs.getString(1));
				sz.setProductName(rs.getString(2));
				sz.setProName(rs.getString(3));
				sz.setTotalPrice(rs.getDouble(4));
				sz.setIsPayment(rs.getInt(5));
				sz.setCreationDate(rs.getDate(6));
				list.add(sz);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}

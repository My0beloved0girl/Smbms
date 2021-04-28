package cn.hfxt.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.BaseDao;
import cn.hfxt.dao.MenuDao;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;

public class MenuDaoImpl extends BaseDao implements MenuDao{

	/*
	 * (查询用户对应的菜单)
	 * @see cn.hfxt.dao.MenuDao#seleMenu(int)
	 */
	@Override
	public List<Menu> seleMenu(int userid) {
		List<Menu> list = new ArrayList<Menu>();
		conn = getConnection();
		String sql = "SELECT * FROM `menu` WHERE `mid` IN(SELECT menuid FROM `user-menu` WHERE userid = ?)"; 
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, userid);
			rs = pre.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMfid(rs.getInt("mfid"));
				menu.setMtype(rs.getInt("mtype"));
				menu.setMbtn(rs.getString("mbtn"));
				menu.setIsdelete(rs.getInt("isdelete"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Menu> seleMenuAn(int mid) {
		List<Menu> list = new ArrayList<Menu>();
		conn = getConnection();
		String sql = "SELECT * FROM `menu` WHERE mfid = ?"; 
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, mid);
			rs = pre.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMfid(rs.getInt("mfid"));
				menu.setMtype(rs.getInt("mtype"));
				menu.setMbtn(rs.getString("mbtn"));
				menu.setIsdelete(rs.getInt("isdelete"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Menu> seleAllMenu() {
		List<Menu> list=new ArrayList<Menu>();
		conn=getConnection();
		String sql="SELECT * FROM `menu`";
		try {
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMfid(rs.getInt("mfid"));
				menu.setMtype(rs.getInt("mtype"));
				menu.setMbtn(rs.getString("mbtn"));
				menu.setIsdelete(rs.getInt("isdelete"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseAll(conn, pre, rs);
		}
		return list;
	}

	@Override
	public List<UserMenu> seleUserMenu(int userid) {
		List<UserMenu> list=new ArrayList<UserMenu>();
		conn=getConnection();
		String sql="SELECT menuid FROM `user-menu` WHERE userid =?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, userid);
			rs=pre.executeQuery();
			while(rs.next()) {
				UserMenu menu = new UserMenu();
				menu.setMenuid(rs.getInt("menuid"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseAll(conn, pre, rs);
		}
		return list;
	}

	@Override
	public int deleFen(int id) {
		String sql = "delete from `user-menu` where userid =?";
		return Operaction(sql, id);
	}

	@Override
	public int addFen(int userid, int menuid) {
		String sql = "INSERT INTO `user-menu`(userid,menuid) VALUES(?,?)";
		return Operaction(sql, userid,menuid);
	}

	@Override
	public int deleQuan(int mid) {
		String sql = "delete from `menu` where mid = ?";
		return Operaction(sql, mid);
	}

	@Override
	public List<Menu> seleEchoMenu(int mid) {
		List<Menu> list=new ArrayList<Menu>();
		conn=getConnection();
		String sql="SELECT * FROM `menu` where mid = ?";
		try {
			pre=conn.prepareStatement(sql);
			pre.setInt(1, mid);
			rs=pre.executeQuery();
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMid(rs.getInt("mid"));
				menu.setMname(rs.getString("mname"));
				menu.setMfid(rs.getInt("mfid"));
				menu.setMtype(rs.getInt("mtype"));
				menu.setMbtn(rs.getString("mbtn"));
				menu.setIsdelete(rs.getInt("isdelete"));
				menu.setMurl(rs.getString("murl"));
				list.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseAll(conn, pre, rs);
		}
		return list;
	}

	@Override
	public int updateMenu(Menu menu) {
		String sql = "UPDATE `menu` SET mname= ?,mfid=?,`mtype`= ?,mbtn= ?,mbtn= ?,isdelete=? WHERE `mid`= ?";
		return Operaction(sql, menu);
	}

}

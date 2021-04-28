package cn.hfxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hfxt.dao.MenuDao;
import cn.hfxt.dao.impl.MenuDaoImpl;
import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;
import cn.hfxt.service.MenuService;
import cn.hfxt.utils.Layui;

public class MenuServiceImpl implements MenuService{

	private MenuDao md = new MenuDaoImpl();
	
	
	/*
	 * (查询用户对应的菜单)
	 * @see cn.hfxt.service.MenuService#seleMenu(int)
	 */
	@Override
	public List<Menu> seleMenu(int userid) {
		return md.seleMenu(userid);
	}


	@Override
	public List<Menu> seleMenuAn(int mid) {
		return md.seleMenuAn(mid);
	}


	@Override
	public Layui<FenMenu> seleAllMenu() {
		Layui<FenMenu> layui = new Layui<FenMenu>();
		List<Menu> seleAllMenu = md.seleAllMenu();
		
		System.out.println("seleAllMenu.size():"+seleAllMenu.size());
		List<FenMenu> fen = new ArrayList<FenMenu>();
		layui.setCode(0);
		layui.setCount(0);
		layui.setMessage("");
		for (Menu menu : seleAllMenu) {
			FenMenu fenMenu = new FenMenu();
			fenMenu.setId(menu.getMid());
			fenMenu.setParentId(menu.getMfid());
			fenMenu.setTitle(menu.getMname());
			fenMenu.setCheckArr("0");
			fen.add(fenMenu);
		}
		layui.setData(fen);
		return layui;
	}


	@Override
	public List<UserMenu> seleUserMenu(int uid) {
		// TODO Auto-generated method stub
		return md.seleUserMenu(uid);
	}


	@Override
	public int deleFen(int id) {
		// TODO Auto-generated method stub
		return md.deleFen(id);
	}


	@Override
	public int addFen(int userid, int menuid) {
		// TODO Auto-generated method stub
		return md.addFen(userid, menuid);
	}


	@Override
	public List<Menu> AllMenu() {
		return md.seleAllMenu();
	}


	@Override
	public Layui<Menu> seleAll() {
		return null;
	}


	@Override
	public int deleQuan(int mid) {
		return md.deleQuan(mid);
	}


	@Override
	public List<Menu> seleEchoMenu(int mid) {
		return md.seleEchoMenu(mid);
	}


	@Override
	public int updateMenu(Menu menu) {
		return md.updateMenu(menu);
	}
	
}

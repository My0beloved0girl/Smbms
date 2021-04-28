package cn.hfxt.service;

import java.util.List;

import cn.hfxt.entity.FenMenu;
import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;
import cn.hfxt.utils.Layui;

public interface MenuService {
	//查询用户对应的菜单
	public List<Menu> seleMenu(int userid);
	public List<Menu> seleMenuAn(int mid);
	public Layui<FenMenu> seleAllMenu() ;
	public List<UserMenu> seleUserMenu(int uid);
	public int deleFen(int id);
	public int addFen(int userid,int menuid);
	public List<Menu> AllMenu(); 
	public Layui<Menu> seleAll() ;
	public int deleQuan(int mid) ;
	public List<Menu> seleEchoMenu(int mid);
	
	public int updateMenu(Menu menu);
}

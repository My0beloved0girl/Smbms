package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;

public interface MenuDao {
	//查询用户对于的菜单
	public List<Menu> seleMenu(int userid);
	
	public List<Menu> seleMenuAn(int mid);
	//查询所有权限
	public List<Menu> seleAllMenu(); 
	
	public List<UserMenu> seleUserMenu(int uid);
	
	//删除
	public int deleFen(int id);
	
	public int addFen(int userid,int menuid);
	
	//删除权限
	public int deleQuan(int mid);
	
	//回显
	public List<Menu> seleEchoMenu(int mid);
	
	//修改
	int updateMenu(Menu menu);
	
}

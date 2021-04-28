package cn.hfxt.dao;

import java.util.List;

import cn.hfxt.entity.Menu;
import cn.hfxt.entity.UserMenu;

public interface MenuDao {
	//��ѯ�û����ڵĲ˵�
	public List<Menu> seleMenu(int userid);
	
	public List<Menu> seleMenuAn(int mid);
	//��ѯ����Ȩ��
	public List<Menu> seleAllMenu(); 
	
	public List<UserMenu> seleUserMenu(int uid);
	
	//ɾ��
	public int deleFen(int id);
	
	public int addFen(int userid,int menuid);
	
	//ɾ��Ȩ��
	public int deleQuan(int mid);
	
	//����
	public List<Menu> seleEchoMenu(int mid);
	
	//�޸�
	int updateMenu(Menu menu);
	
}

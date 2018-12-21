package com.yena.shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.dao.MenuDao;
import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.model.User;
import com.yena.shop.security.Aria;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public void insertMenu(Menu menu) {
		menuDao.insertMenu(menu);
	}

	@Override
	public List selectMenu() {
		return menuDao.selectMenu();
	}

	@Override
	public Menu selectMenuOne(Menu menu) {
		return menuDao.selectMenuOne(menu);
	}

	@Override
	public int updateMenu(Menu menu) {
		return menuDao.updateMenu(menu);
	}
	
	// 서브메뉴 정보수정
	public int updateSubMenu(SubMenu subMenu) {
		return menuDao.updateSubMenu(subMenu);
	}
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd) {
		menuDao.deleteMenu(menuCd);
	}
	
	// 서브메뉴 최대 코드값 조회
	public int selectMaxSubMenuCd() {
		return menuDao.selectMaxSubMenuCd();
	}

	// 서브메뉴 등록
	public void insertSubMenu(SubMenu subMenu) {
		menuDao.insertSubMenu(subMenu);
	}
	
	// 서브메뉴 조회
	public List selectSubMenu(int menuCd) {
		return menuDao.selectSubMenu(menuCd);
	}
	
	// 서브메뉴 삭제
	public void deleteSubMenu(SubMenu subMenu) {
		menuDao.deleteSubMenu(subMenu);
	}
	
	// 서브메뉴 1개 조회
	public SubMenu selectSubMenuOne(SubMenu subMenu) {
		return menuDao.selectSubMenuOne(subMenu);
	}
	
	// 모든 메뉴 목록 조회
	public List<Menu> selectAllMenuList(){
		List<Menu> list = menuDao.selectMenu();
		for(int i=0; i<list.size(); i++) {
			Menu menu = list.get(i);
			menu.setSubMenuList(menuDao.selectSubMenu(menu.getMenu_cd()));
			list.set(i, menu);
		}
		return list;
	}
}

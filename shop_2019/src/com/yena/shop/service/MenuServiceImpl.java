package com.yena.shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.dao.MenuDao;
import com.yena.shop.model.Menu;
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
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd) {
		menuDao.deleteMenu(menuCd);
	}
}

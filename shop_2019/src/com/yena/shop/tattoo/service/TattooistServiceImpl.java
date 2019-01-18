package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.tattoo.dao.TattooistDao;

public class TattooistServiceImpl implements TattooistService{
	
	TattooistDao tattooistDao;

	public void setTattooistDao(TattooistDao tattooistDao) {
		this.tattooistDao = tattooistDao;
	}

	@Override
	public List selectTattooist() {
		return tattooistDao.selectTattooist();
	}

	@Override
	public Menu selectTattooistOne(Menu menu) {
		return tattooistDao.selectTattooistOne(menu);
	}

	@Override
	public int updateTattooist(Menu menu) {
		return tattooistDao.updateTattooist(menu);
	}

	@Override
	public void deleteTattooist(int menuCd) {
		tattooistDao.deleteTattooist(menuCd);
	}

	@Override
	public void insertTattooist(SubMenu subMenu) {
		tattooistDao.insertTattooist(subMenu);
	}

}

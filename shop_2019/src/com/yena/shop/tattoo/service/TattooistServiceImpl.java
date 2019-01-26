package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.tattoo.dao.TattooistDao;
import com.yena.shop.tattoo.model.Tattooist;

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
	public Tattooist selectTattooistOne(Tattooist tattooist) {
		return tattooistDao.selectTattooistOne(tattooist);
	}

	@Override
	public int updateTattooist(Tattooist tattooist) {
		return tattooistDao.updateTattooist(tattooist);
	}

	@Override
	public void deleteTattooist(String seq) {
		tattooistDao.deleteTattooist(seq);
	}

	@Override
	public void insertTattooist(Tattooist tattooist) {
		tattooistDao.insertTattooist(tattooist);
	}

	
}

package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.tattoo.dao.TattooColorDao;
import com.yena.shop.tattoo.model.TattooColor;

public class TattooColorServiceImpl implements TattooColorService{
	
	TattooColorDao tattooColorDao;

	public void setTattooColorDao(TattooColorDao tattooColorDao) {
		this.tattooColorDao = tattooColorDao;
	}

	@Override
	public List selectTattooColor() {
		return tattooColorDao.selectTattooColor();
	}

	@Override
	public TattooColor selectTattooColorOne(TattooColor tattooColor) {
		return tattooColorDao.selectTattooColorOne(tattooColor);
	}

	@Override
	public void deleteTattooColor(String seq) {
		tattooColorDao.deleteTattooColor(seq);
	}

	@Override
	public void insertTattooColor(TattooColor tattooColor) {
		tattooColorDao.insertTattooColor(tattooColor);
	}

	
}

package com.yena.shop.tattoo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.security.Aria;
import com.yena.shop.tattoo.dao.TattooDao;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;

public class TattooServiceImpl implements TattooService {
	
	private TattooDao tattooDao;

	public void setTattooDao(TattooDao tattooDao) {
		this.tattooDao = tattooDao;
	}
	// 타투 상품 등록
	@Override
	public void insertTattoo(Tattoo tattoo) {
		tattooDao.insertTattoo(tattoo);
	}
	
	// 타투 전체 개수
	@Override
	public int selectTotalTattoo(Page pageVo) {
		return tattooDao.selectTotalTattoo(pageVo);
	}

	// 타투 상품 수정
	@Override
	public void updateTattoo(Tattoo tattoo) {
		tattooDao.updateTattoo(tattoo);
	}

	// 타투 상품 목록 조회
	@Override
	public List selectTattooList(Page page) {
		return tattooDao.selectTattooList(page);
	}

	// 타투 상품 단품 상세보기
	@Override
	public Tattoo selectTattooOne(int id) {
		return tattooDao.selectTattooOne(id);
	}
	
	// 타투 상품 삭제
	@Override
	public void deleteGoods(int id) {
		 tattooDao.deleteGoods(id);
		
	}
	
	
	
}

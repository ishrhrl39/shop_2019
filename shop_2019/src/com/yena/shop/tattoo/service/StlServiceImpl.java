package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.tattoo.dao.StlDao;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Stl;

public class StlServiceImpl implements StlService {
	private StlDao stlDao;
	
	public void setStlDao(StlDao stlDao) {
		this.stlDao = stlDao;
	}

	/**
	 * 무통장 이력 등록
	 * @param stl
	 */
	public void insertStl(Stl stl) {
		stlDao.insertStl(stl);
	}
	
	/**
	 * 무통장 이력 삭제
	 * @param stl_no
	 */
	public void deleteStl(int stl_no) {
		stlDao.deleteStl(stl_no);
	}
	
	/**
	 * 무통장 이력 1개 조회
	 * @param stl_no
	 * @return
	 */
	public Stl selectStlOne(int stl_no) {
		return stlDao.selectStlOne(stl_no);
	}
	
	/**
	 * 무통장 이력 모두 조회
	 * @param stl
	 * @return
	 */
	public List selectStlList(Page pageVo) {
		return stlDao.selectStlList(pageVo);
	}
	
	/**
	 * 무통장 이력 건수 조회
	 * @param pageVo
	 * @return
	 */
	public int selectTotalStl(Page pageVo) {
		return stlDao.selectTotalStl(pageVo);
	}
}

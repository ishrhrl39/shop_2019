package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;
import com.yena.shop.tattoo.model.Stl;

public interface StlService {
	/**
	 * 무통장 이력 등록
	 * @param stl
	 */
	public void insertStl(Stl stl);
	
	/**
	 * 무통장 이력 삭제
	 * @param stl_no
	 */
	public void deleteStl(int stl_no);
	
	/**
	 * 무통장 이력 1개 조회
	 * @param stl_no
	 * @return
	 */
	public Stl selectStlOne(int stl_no);
	
	/**
	 * 무통장 이력 모두 조회
	 * @param stl
	 * @return
	 */
	public List selectStlList(Page pageVo);
	
	/**
	 * 무통장 이력 건수 조회
	 * @param pageVo
	 * @return
	 */
	public int selectTotalStl(Page pageVo);
	
}

package com.yena.shop.service;

import java.util.List;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;

public interface TattooistService {

	// 타투 담당자 목록 조회
	public List selectTattooist();
	
	// 타투 담당자 1명 조회
	public Menu selectTattooistOne(Menu menu);
	
	// 타투 담당자 수정
	public int updateTattooist(Menu menu);
	
	// 타투 담당자 삭제
	public void deleteTattooist(int menuCd);

	// 타투 담당자 삽입
	public void insertTattooist(SubMenu subMenu);
}

package com.yena.shop.dao;

import java.util.List;

import com.yena.shop.model.Menu;

public interface MenuDao {
	// 그룹메뉴 등록
	public void insertMenu(Menu menu);
	
	public List selectMenu();
	
	// 그룹메뉴 정보조회
	public Menu selectMenuOne(Menu menu);
	
	// 그룹메뉴 정보수정
	public int updateMenu(Menu menu);
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd);
}

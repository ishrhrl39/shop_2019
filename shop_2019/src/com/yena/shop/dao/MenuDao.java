package com.yena.shop.dao;

import java.util.List;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;

public interface MenuDao {
	// 그룹메뉴 등록
	public void insertMenu(Menu menu);
	
	public List selectMenu();
	
	// 그룹메뉴 정보조회
	public Menu selectMenuOne(Menu menu);
	
	// 그룹메뉴 정보수정
	public int updateMenu(Menu menu);
	
	// 서브메뉴 정보수정
	public int updateSubMenu(SubMenu subMenu);
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd);
	
	// 서브메뉴 최대 코드값 조회
	public int selectMaxSubMenuCd();

	// 서브메뉴 등록
	public void insertSubMenu(SubMenu subMenu);
	
	// 서브메뉴 조회
	public List selectSubMenu(int menuCd);
	
	// 서브메뉴 삭제
	public void deleteSubMenu(SubMenu subMenu);
	
	// 서브메뉴 1개 조회
	public SubMenu selectSubMenuOne(SubMenu subMenu);
	
}

package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;

public class TattooDaoImpl extends SqlMapClientDaoSupport implements MenuDao {
	
	@Autowired
	public TattooDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapMenu.";
		
	// 그룹메뉴 등록
	@Override
	public void insertMenu(Menu menu) {
		getSqlMapClientTemplate().insert(namespace+"insertMenu", menu);
	}

	
	@Override
	public List selectMenu() {
		return getSqlMapClientTemplate().queryForList(namespace + "selectMenu");
	}
	
	// 그룹메뉴 정보 조회
	@Override
	public Menu selectMenuOne(Menu menu){
		return (Menu) getSqlMapClientTemplate().queryForObject(namespace + "selectMenuOne", menu);
	}
	
	// 서브메뉴 1개 조회
	public SubMenu selectSubMenuOne(SubMenu subMenu) {
		return (SubMenu) getSqlMapClientTemplate().queryForObject(namespace + "selectSubMenuOne", subMenu);
	}

	// 그륩메뉴 정보수정
	public int updateMenu(Menu menu){
		return getSqlMapClientTemplate().update(namespace + "updateMenu", menu);
	}
	
	// 서브메뉴 정보수정
	public int updateSubMenu(SubMenu subMenu) {
		return getSqlMapClientTemplate().update(namespace + "updateSubMenu", subMenu);
	}
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd) {
		getSqlMapClientTemplate().update(namespace + "deleteMenu", menuCd);
	}
	
	// 서브메뉴 최대 코드값 조회
	public int selectMaxSubMenuCd() {
		Object obj = getSqlMapClientTemplate().queryForObject(namespace + "selectMaxSubMenuCd");
		if(obj == null) {
			return 0;
		}
		return (Integer)obj;
	}

	// 서브메뉴 등록
	public void insertSubMenu(SubMenu subMenu) {
		getSqlMapClientTemplate().insert(namespace+"insertSubMenu", subMenu);
	}
	
	// 서브메뉴 조회
	public List selectSubMenu(int menuCd){
		return getSqlMapClientTemplate().queryForList(namespace + "selectSubMenu", menuCd);
	}
	
	// 서브메뉴 삭제
	public void deleteSubMenu(SubMenu subMenu) {
		getSqlMapClientTemplate().delete(namespace + "deleteSubMenu", subMenu);
	}
}

package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.Menu;

public class MenuDaoImpl extends SqlMapClientDaoSupport implements MenuDao {
	
	@Autowired
	public MenuDaoImpl(SqlMapClient sqlMapClient) {
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

	// 그륩메뉴 정보수정
	public int updateMenu(Menu menu){
		return getSqlMapClientTemplate().update(namespace + "updateMenu", menu);
	}
	
	// 그룹메뉴 삭제
	public void deleteMenu(int menuCd) {
		getSqlMapClientTemplate().update(namespace + "deleteMenu", menuCd);
	}
}

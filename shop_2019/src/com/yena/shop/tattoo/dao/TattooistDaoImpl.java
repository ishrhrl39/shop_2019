package com.yena.shop.tattoo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;

public class TattooistDaoImpl extends SqlMapClientDaoSupport implements TattooistDao {
	
	@Autowired
	public TattooistDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapTattooist.";

	@Override
	public List selectTattooist() {
		return getSqlMapClientTemplate().queryForList(namespace + "selectTattooist");
	}

	@Override
	public Menu selectTattooistOne(Menu menu) {
		return (Menu) getSqlMapClientTemplate().queryForObject(namespace + "selectTattooistOne", menu);
	}

	@Override
	public int updateTattooist(Menu menu) {
		return getSqlMapClientTemplate().update(namespace + "updateTattooist", menu);
	}

	@Override
	public void deleteTattooist(int menuCd) {
		getSqlMapClientTemplate().delete(namespace + "deleteTattooist", menuCd);
	}

	@Override
	public void insertTattooist(SubMenu subMenu) {
		getSqlMapClientTemplate().insert(namespace + "insertTattooist", subMenu);
	}
		

}

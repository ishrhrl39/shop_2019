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
import com.yena.shop.tattoo.model.Tattooist;

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
	public Tattooist selectTattooistOne(Tattooist tattooist) {
		return (Tattooist) getSqlMapClientTemplate().queryForObject(namespace + "selectTattooistOne", tattooist);
	}

	@Override
	public int updateTattooist(Tattooist tattooist) {
		return getSqlMapClientTemplate().update(namespace + "updateTattooist", tattooist);
	}

	@Override
	public void deleteTattooist(String seq) {
		getSqlMapClientTemplate().delete(namespace + "deleteTattooist", seq);
	}

	@Override
	public void insertTattooist(Tattooist tattooist) {
		getSqlMapClientTemplate().insert(namespace + "insertTattooist", tattooist);
	}
		

}

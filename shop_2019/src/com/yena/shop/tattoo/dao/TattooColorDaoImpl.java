package com.yena.shop.tattoo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.tattoo.model.TattooColor;

public class TattooColorDaoImpl extends SqlMapClientDaoSupport implements TattooColorDao {
	
	@Autowired
	public TattooColorDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapTattooColor.";

	@Override
	public List selectTattooColor() {
		return getSqlMapClientTemplate().queryForList(namespace + "selectTattooColor");
	}

	@Override
	public TattooColor selectTattooColorOne(TattooColor tattooColor) {
		return (TattooColor) getSqlMapClientTemplate().queryForObject(namespace + "selectTattooColorOne", tattooColor);
	}


	@Override
	public void deleteTattooColor(String seq) {
		getSqlMapClientTemplate().delete(namespace + "deleteTattooColor", seq);
	}

	@Override
	public void insertTattooColor(TattooColor tattooColor) {
		getSqlMapClientTemplate().insert(namespace + "insertTattooColor", tattooColor);
	}
		

}

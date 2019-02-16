package com.yena.shop.tattoo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;
import com.yena.shop.tattoo.model.Stl;

public class StlDaoImpl extends SqlMapClientDaoSupport implements StlDao {
	@Autowired
	public StlDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapStl.";

	@Override
	public void insertStl(Stl stl) {
		getSqlMapClientTemplate().insert(namespace + "insertStl", stl);
	}

	@Override
	public void deleteStl(int stl_no) {
		getSqlMapClientTemplate().delete(namespace + "deleteStl", stl_no);
	}

	@Override
	public Stl selectStlOne(int stl_no) {
		return (Stl) getSqlMapClientTemplate().queryForObject(namespace + "selectStlOne", stl_no);
	}

	@Override
	public List selectStlList(Page page) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectStlList", page);
	}
	
	@Override
	public int selectTotalStl(Page pageVo) {
		return (int) getSqlMapClientTemplate().queryForObject(namespace + "selectTotalStl", pageVo);
	}
}

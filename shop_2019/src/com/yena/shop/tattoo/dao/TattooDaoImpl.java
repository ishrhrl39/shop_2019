package com.yena.shop.tattoo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;

public class TattooDaoImpl extends SqlMapClientDaoSupport implements TattooDao {
	
	@Autowired
	public TattooDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapTattoo.";
		

	// 타투 상품 등록
	@Override
	public void insertTattoo(Tattoo tattoo) {
		getSqlMapClientTemplate().insert(namespace + "insertTattoo", tattoo);
	}

	// 타투 상품 수정
	@Override
	public void updateTattoo(Tattoo tattoo) {
		getSqlMapClientTemplate().update(namespace + "updateTattoo", tattoo);
	}

	// 타투 상품 목록 조회
	@Override
	public List selectTattooList(Page page) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectTattooList", page);
	}

	// 타투 상품 단품 상세보기
	@Override
	public Tattoo selectTattooOne(int id) {
		return (Tattoo) getSqlMapClientTemplate().queryForObject(namespace + "selectTattooOne", id);
	}

	// 타투 전체개수
	@Override
	public int selectTotalTattoo(Page pageVo) {
		return (int) getSqlMapClientTemplate().queryForObject(namespace + "selectTotalTattoo", pageVo);
	}
}

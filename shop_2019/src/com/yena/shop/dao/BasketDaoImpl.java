package com.yena.shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.Basket;

public class BasketDaoImpl extends SqlMapClientDaoSupport implements BasketDao {
	
	@Autowired
	public BasketDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	private String namespace = "SqlMapBasket.";

	// 장바구니 삽입
	@Override
	public void insertBasket(Basket basket) {
		getSqlMapClientTemplate().insert(namespace + "insertBasket", basket);
	}

	// 장바구니 조회
	@Override
	public List<Basket>  selectBasket(String id) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectBasket", id);
		
	}
	
	
	
}

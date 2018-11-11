package com.yena.shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.User;

public class AccountDaoImpl extends SqlMapClientDaoSupport implements AccountDao {
	
	@Autowired
	public AccountDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapAccount.";
		
	@Override
	public void insertUser(User user) {
		getSqlMapClientTemplate().insert(namespace+"insertUser", user);
	}

}

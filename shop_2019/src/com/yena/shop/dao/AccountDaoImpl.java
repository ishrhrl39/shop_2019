package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

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
		
	// 회원 가입
	@Override
	public void insertUser(User user) {
		getSqlMapClientTemplate().insert(namespace+"insertUser", user);
	}

	// 아이디 중복 체크
	@Override
	public int duplCheckId(String id) {
		System.out.println(id);
		return (int)getSqlMapClientTemplate().queryForObject(namespace+"duplCheckId", id);
	}
	
	@Override
	public List selectUser(Map map) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectUser", map);
	}

	@Override
	public int selectTotalUserCount(Map map) {
		return (int) getSqlMapClientTemplate().queryForObject(namespace + "selectTotalUserCount", map);
	}
	
	@Override
	public User selectUserOne(User user){
		return (User) getSqlMapClientTemplate().queryForObject(namespace + "selectUserOne", user);
	}

}

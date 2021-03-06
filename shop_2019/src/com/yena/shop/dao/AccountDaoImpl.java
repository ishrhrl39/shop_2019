package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;

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
	
	// 회원 정보 조회
	@Override
	public User selectUserOne(User user){
		return (User) getSqlMapClientTemplate().queryForObject(namespace + "selectUserOne", user);
	}

	// 회원 정보수정
	public int updateUser(User user){
		return getSqlMapClientTemplate().update(namespace + "updateUser", user);
	}

	// 회원 탈퇴사유 조회
	@Override
	public List selectWithDraw() {
		return getSqlMapClientTemplate().queryForList(namespace + "selectWithDraw");
	}

	// 회원 탈퇴사유 로그 남기기
	@Override
	public void insertWithdrawLog(WithDrawLog withDrawLog) {
		getSqlMapClientTemplate().insert(namespace + "insertWithdrawLog", withDrawLog);
	}
	
	public User findUserById(String id) {
		return (User) getSqlMapClientTemplate().queryForObject(namespace + "findUserById",id);
	}
}

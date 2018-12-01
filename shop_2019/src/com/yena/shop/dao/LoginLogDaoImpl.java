package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.LoginLog;
import com.yena.shop.model.User;

public class LoginLogDaoImpl extends SqlMapClientDaoSupport implements LoginLogDao {
	
	@Autowired
	public LoginLogDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapLoginLog.";
	
	// 로그인 이력 저장
	public void insertLoginLog(LoginLog loginLog){
		getSqlMapClientTemplate().insert(namespace + "insertLoginLog", loginLog);
	}
	
	// 로그인 이력 조회
	public List selectLoginLog(Map map){
		return getSqlMapClientTemplate().queryForList(namespace + "selectLoginLog", map);
	}
	
	// 로그인 이력 전체개수 조회
	public int selectTotalLoginLogCount(){
		return (int) getSqlMapClientTemplate().queryForObject(namespace + "selectTotalLoginLogCount");
	}
}

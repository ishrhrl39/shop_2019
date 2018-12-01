package com.yena.shop.service;

import java.util.List;
import java.util.Map;
import com.yena.shop.dao.LoginLogDao;
import com.yena.shop.model.LoginLog;

public class LoginLogServiceImpl implements LoginLogService {
	
	private LoginLogDao loginLogDao;

	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
	
	// 로그인 이력 저장
	public void insertLoginLog(LoginLog loginLog){
		loginLogDao.insertLoginLog(loginLog);
	}

	// 로그인 이력 조회
	public List selectLoginLog(Map map){
		return loginLogDao.selectLoginLog(map);
	}
	
	// 로그인 이력 전체개수 조회
	public int selectTotalLoginLogCount(){
		return loginLogDao.selectTotalLoginLogCount();
	}
}

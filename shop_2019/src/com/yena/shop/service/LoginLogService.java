package com.yena.shop.service;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.LoginLog;
import com.yena.shop.model.User;

public interface LoginLogService {
	// 로그인 이력 저장
	public void insertLoginLog(LoginLog loginLog);
	
	// 로그인 이력 조회
	public List selectLoginLog(Map map);
	
	// 로그인 이력 전체개수 조회
	public int selectTotalLoginLogCount();
}

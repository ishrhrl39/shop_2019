package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;

public interface AccountDao {
	// 회원 가입
	public void insertUser(User user);
	
	// 아이디 중복 체크
	public int duplCheckId(String id);
	
	public List selectUser(Map map);
	
	public int selectTotalUserCount();
}

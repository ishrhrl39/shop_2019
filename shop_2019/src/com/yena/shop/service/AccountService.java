package com.yena.shop.service;

import com.yena.shop.model.User;

public interface AccountService {
	// 회원 가입
	public void insertUser(User user);
	
	// 아이디 중복 체크
	public int duplCheckId(String id);
}

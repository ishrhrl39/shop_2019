package com.yena.shop.service;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;

public interface AccountService {
	// 회원 가입
	public void insertUser(User user);
	
	// 아이디 중복 체크
	public int duplCheckId(String id);
	
	public List<User> selectUser(Map map);
	
	public int selectTotalUserCount(Map map);
	
	// 회원 정보조회
	public User selectUserOne(User user);

	// 회원 정보수정
	public int updateUser(User user);

}

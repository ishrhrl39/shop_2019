package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;

public interface AccountDao {
	// 회원 가입
	public void insertUser(User user);
	
	// 아이디 중복 체크
	public int duplCheckId(String id);
	
	public List selectUser(Map map);
	
	public int selectTotalUserCount(Map map);
	
	// 회원 정보조회
	public User selectUserOne(User user);
	
	// 회원 정보수정
	public int updateUser(User user);
	
	// 회원 탈퇴사유 조회
	public List selectWithDraw();
	
	// 회원 탈퇴사유 로그 남기기
	public void insertWithdrawLog(WithDrawLog withDrawLog);
	
	public User findUserById(String id);
}

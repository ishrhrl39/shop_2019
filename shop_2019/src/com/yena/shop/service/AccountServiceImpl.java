package com.yena.shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.security.Aria;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	// 회원 가입
	@Override
	public void insertUser(User user) {
		accountDao.insertUser(user);
	}

	// 아이디 중복 체크
	@Override
	public int duplCheckId(String id) {
		return accountDao.duplCheckId(id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectUser(Map map) {
		List<User> list = accountDao.selectUser(map);
		for(int i=0; i<list.size(); i++){
			User user = (User) list.get(i);
			try {
				Aria.setCharset("UTF-8");
				user.setName(Aria.decrypt(user.getName()));
				list.set(i, user);
			} catch (Exception e) {
			}
		}
		return list;
	}

	@Override
	public int selectTotalUserCount(Map map) {
		return accountDao.selectTotalUserCount(map);
	}

	// 회원 정보조회
	@Override
	public User selectUserOne(User user){
		return accountDao.selectUserOne(user);
	}
	
	// 회원 정보수정
	public int updateUser(User user){
		return accountDao.updateUser(user);
	}

	// 회원 탈퇴사유 조회
	@Override
	public List selectWithDraw() {
		return accountDao.selectWithDraw();
	}

	// 회원 탈퇴사유 로그 남기기
	@Override
	public void insertWithdrawLog(WithDrawLog withDrawLog) {
		accountDao.insertWithdrawLog(withDrawLog);
	}
}

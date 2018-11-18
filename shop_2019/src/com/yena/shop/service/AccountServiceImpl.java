package com.yena.shop.service;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.model.User;

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

}

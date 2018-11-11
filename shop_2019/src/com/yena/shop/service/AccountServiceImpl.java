package com.yena.shop.service;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.model.User;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void insertUser(User user) {
		accountDao.insertUser(user);
	}

}

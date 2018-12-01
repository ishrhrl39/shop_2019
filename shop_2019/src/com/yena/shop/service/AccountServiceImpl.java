package com.yena.shop.service;

import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.model.User;
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
	public List selectUser(Map map) {
		List list = accountDao.selectUser(map);
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

	@Override
	public User selectUserOne(User user){
		return accountDao.selectUserOne(user);
	}
}

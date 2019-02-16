package com.yena.shop.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yena.shop.dao.AccountDao;
import com.yena.shop.dao.FaqDao;
import com.yena.shop.model.Faq;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.security.Aria;

public class FaqServiceImpl implements FaqService {
	
	private FaqDao faqDao;

	public void setFaqDao(FaqDao faqDao) {
		this.faqDao = faqDao;
	}

	@Override
	public void insertFaq(Faq faq) {
		faqDao.insertFaq(faq);
	}

	@Override
	public void updateFaq(Faq faq) {
		faqDao.updateFaq(faq);
	}

	@Override
	public void deteleFaq(int no) {
		faqDao.deteleFaq(no);
	}

	@Override
	public Faq selectFaqOne(int no) {
		return faqDao.selectFaqOne(no);
	}

	@Override
	public List selectFaqList() {
		return faqDao.selectFaqList();
	}

	
}

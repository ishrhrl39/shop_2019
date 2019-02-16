package com.yena.shop.dao;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.Faq;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;

public interface FaqDao {
	// FAQ 등록
	public void insertFaq(Faq faq);
	
	// FAQ 수정
	public void updateFaq(Faq faq);
	
	// FAQ 삭제
	public void deteleFaq(int no);
	
	// FAQ 조회
	public Faq selectFaqOne(int no);
	
	// FAQ 모두 조회
	public List selectFaqList();
}

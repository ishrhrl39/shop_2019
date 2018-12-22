package com.yena.shop.tattoo.service;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.tattoo.model.Tattoo;

public interface TattooService {
	// 타투 상품 등록 
	public void insertTattoo(Tattoo tattoo);
	
	// 타투 상품 수정
	public void updateTattoo(Tattoo tattoo);
	
	// 타투 상품 목록 조회
	public List selectTattooList(Map param);
	
	// 타투 상품 단품 상세보기
	public Tattoo selectTattooOne(int id);
}

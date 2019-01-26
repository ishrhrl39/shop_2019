package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.tattoo.model.TattooColor;

public interface TattooColorService {

	// 타투 담당자 목록 조회
	public List selectTattooColor();
	
	// 타투 담당자 1명 조회
	public TattooColor selectTattooColorOne(TattooColor tattooColor);
	// 타투 담당자 삭제
	public void deleteTattooColor(String seq);

	// 타투 담당자 삽입
	public void insertTattooColor(TattooColor tattooColor);
}

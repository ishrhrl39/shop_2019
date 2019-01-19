package com.yena.shop.tattoo.dao;

import java.util.List;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.tattoo.model.Tattooist;

public interface TattooistDao {

	// 타투 담당자 목록 조회
	public List selectTattooist();
	
	// 타투 담당자 1명 조회
	public Tattooist selectTattooistOne(Tattooist tattooist);
	
	// 타투 담당자 수정
	public int updateTattooist(Tattooist tattooist);
	
	// 타투 담당자 삭제
	public void deleteTattooist(String seq);

	// 타투 담당자 삽입
	public void insertTattooist(Tattooist tattooist);
}

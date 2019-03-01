package com.yena.shop.tattoo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;

public interface TattooDao {
	// 타투 상품 등록 
	public void insertTattoo(Tattoo tattoo);
	
	// 타투 상품 수정
	public void updateTattoo(Tattoo tattoo);
	
	// 타투 상품 목록 조회
	public List selectTattooList(Page page);
	
	// 타투 상품 단품 상세보기
	public Tattoo selectTattooOne(int id);

	// 타투 전체 개수
	public int selectTotalTattoo(Page pageVo);

	// 타투 상품 삭제
	public void deleteGoods(int id);
	
	// 할인 진행 중인 상품 베스트
	public ArrayList<Tattoo> selectBestSalePayment();
	
	// 신상품 최신 목록
	public ArrayList<Tattoo> selectNewTattoo();
}

package com.yena.shop.service;

import java.util.List;

import com.yena.shop.model.Basket;

public interface BasketService {
	// 장바구니 삽입
	public void insertBasket(Basket basket);
	
	// 장바구니 조회
	public List<Basket> selectBasket(String id);

	// 장바구니 삭제
	public void deleteBasket(String item);

	// 장바구니 단건 조회
	public Basket selectBasketOne(Basket basket);

}

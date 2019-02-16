package com.yena.shop.service;

import java.util.List;

import com.yena.shop.model.Basket;

public interface BasketService {
	// 장바구니 삽입
	public void insertBasket(Basket basket);
	
	// 장바구니 조회
	public List<Basket> selectBasket(String id);

}

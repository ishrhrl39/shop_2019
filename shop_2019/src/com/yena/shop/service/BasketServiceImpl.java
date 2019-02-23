package com.yena.shop.service;

import java.util.List;

import com.yena.shop.dao.BasketDao;
import com.yena.shop.model.Basket;

public class BasketServiceImpl implements BasketService {
	
	private BasketDao basketDao;

	public void setBasketDao(BasketDao basketDao) {
		this.basketDao = basketDao;
	}

	// 장바구니 삽입
	@Override
	public void insertBasket(Basket basket) {
		basketDao.insertBasket(basket);
	}

	// 장바구니 조회
	@Override
	public List<Basket> selectBasket(String id) {
		return basketDao.selectBasket(id);
	}

	// 장바구니 삭제
	@Override
	public void deleteBasket(String item) {
		basketDao.deleteBasket(item);
	}
	
	// 장바구니 단건 조회
	public Basket selectBasketOne(Basket basket) {
		return basketDao.selectBasketOne(basket);
	}
	
	
	
	

}

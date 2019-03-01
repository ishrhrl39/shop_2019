package com.yena.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.service.MenuService;
import com.yena.shop.tattoo.model.Payment;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.PaymentService;
import com.yena.shop.tattoo.service.TattooService;

public class IndexController extends MultiActionController{
	
	MenuService menuService;
	PaymentService paymentService;
	TattooService tattooService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public void setTattooService(TattooService tattooService) {
		this.tattooService = tattooService;
	}
	
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		
		ArrayList<Payment> bestPaymentList = (ArrayList<Payment>) paymentService.selectBestPayment();
		ArrayList<Tattoo> saleBestList = (ArrayList<Tattoo>) tattooService.selectBestSalePayment();
		ArrayList<Tattoo> newTattooList = (ArrayList<Tattoo>) tattooService.selectNewTattoo();
		List<Tattoo> tattooList = new ArrayList<Tattoo>();
		
		for(Payment payment : bestPaymentList) {
			Tattoo tattoo = tattooService.selectTattooOne(payment.getTATTOO_ID());
			if(tattoo != null)
				tattooList.add(tattoo);
		}
		
		System.out.println("BEST.PAYMENT SIZE() => " + tattooList.size());
		returnData.put("paymentBestList", tattooList);
		returnData.put("saleBestList", saleBestList);
		returnData.put("newTattooList", newTattooList);
		return new ModelAndView("main", returnData);
	}
	
	
	public ModelAndView selectMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuService.selectAllMenuList());
		mv.setViewName("jsonView");
		return mv;
	}
}

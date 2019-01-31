package com.yena.shop.tattoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.PaymentService;

public class PaymentController extends MultiActionController{
	private PaymentService paymentService;

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	// 구매하기 메인페이지
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String tattooName = StringUtils.defaultString(request.getParameter("tattooName"), "");
		String tattoPrice = StringUtils.defaultString(request.getParameter("tattoPrice"), "");
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		String tattooImage = StringUtils.defaultString(request.getParameter("tattooImage"), "");
		
		mav.addObject("tattooId", tattooId);
		mav.addObject("tattooName", tattooName);
		mav.addObject("tattoPrice", tattoPrice);
		mav.addObject("color", color);
		mav.addObject("tattooist", tattooist);
		mav.addObject("tattooImage", tattooImage);
		
		mav.setViewName("tattoo_payment");
		return mav;
	}

	

}

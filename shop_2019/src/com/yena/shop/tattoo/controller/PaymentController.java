package com.yena.shop.tattoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.PaymentService;

public class PaymentController extends MultiActionController{
	private PaymentService paymentService;
	private String secretKey = Aria.getSecretKey();

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	// 구매하기 메인페이지
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();	// session 객체 가져오기
		User user = (User) session.getAttribute("loginUser"); // session 가져옴
		String name = user.getName();
		String email = user.getEmail();
		String phone = user.getTel();
		
		Aria.setCharset("UTF-8");
		
		ModelAndView mav = new ModelAndView();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String tattooName = StringUtils.defaultString(request.getParameter("tattooName"), "");
		String tattoPrice = StringUtils.defaultString(request.getParameter("tattoPrice"), "");
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		String tattooImage = StringUtils.defaultString(request.getParameter("tattooImage"), "");
		String realTattooPrice = StringUtils.defaultString(request.getParameter("realTattooPrice"), "");
		String salePrice = StringUtils.defaultString(request.getParameter("salePrice"), "");
		System.out.println("name=> " + name);
		System.out.println("secuKey=> " + secretKey);
		System.out.println("name=> " + Aria.decrypt(name, secretKey));
		mav.addObject("tattooId", tattooId);
		mav.addObject("tattooName", tattooName);
		mav.addObject("tattoPrice", tattoPrice);
		mav.addObject("color", color);
		mav.addObject("tattooist", tattooist);
		mav.addObject("tattooImage", tattooImage);
		mav.addObject("name", Aria.decrypt(name, secretKey));
		mav.addObject("email", email);
		mav.addObject("phone", phone);
		mav.addObject("realTattooPrice", realTattooPrice);
		mav.addObject("salePrice", salePrice);
		
		mav.setViewName("tattoo_payment");
		return mav;
	}
	
	// 예약하기
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String tattooName = StringUtils.defaultString(request.getParameter("tattooName"), "");
		String tattoPrice = StringUtils.defaultString(request.getParameter("tattoPrice"), "");
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String reserve_dt = StringUtils.defaultString(request.getParameter("reserve_dt"), "");
		String reserve_tm = StringUtils.defaultString(request.getParameter("reserve_tm"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		
		mav.setViewName("jsonView");
		return mav;
	}
	

	public static void main(String[] args) throws Exception {
		String str = "한예나";
		Aria.setCharset("UTF-8");
		System.out.println(Aria.encrypt(str, Aria.getSecretKey()) );
	}

}

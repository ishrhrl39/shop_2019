package com.yena.shop.tattoo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.service.BasketService;
import com.yena.shop.tattoo.model.Payment;
import com.yena.shop.tattoo.model.Stl;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.model.TattooColor;
import com.yena.shop.tattoo.service.PaymentService;
import com.yena.shop.tattoo.service.StlService;
import com.yena.shop.tattoo.service.TattooColorService;

public class PaymentController extends MultiActionController{
	private PaymentService paymentService;
	private TattooColorService tattooColorService;
	private StlService stlService;
	private String secretKey = Aria.getSecretKey();
	private BasketService basketService;
	

	public void setBasketService(BasketService basketService) {
		this.basketService = basketService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public void setStlService(StlService stlService) {
		this.stlService = stlService;
	}
	public void setTattooColorService(TattooColorService tattooColorService) {
		this.tattooColorService = tattooColorService;
	}
	// 구매하기 메인페이지
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();	// session 객체 가져오기
		User user = (User) session.getAttribute("loginUser"); // session 가져옴
		String name = user.getName();
		String email = user.getEmail();
		String phone = user.getTel();
		
		Aria.setCharset("UTF-8");
		TattooColor tattooColor = new TattooColor();
		
		ModelAndView mav = new ModelAndView();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String tattooName = StringUtils.defaultString(request.getParameter("tattooName"), "");
		String tattoPrice = StringUtils.defaultString(request.getParameter("tattoPrice"), "");
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		String tattooImage = StringUtils.defaultString(request.getParameter("tattooImage"), "");
		String realTattooPrice = StringUtils.defaultString(request.getParameter("realTattooPrice"), "");
		String salePrice = StringUtils.defaultString(request.getParameter("salePrice"), "");
		String basketSn = StringUtils.defaultString(request.getParameter("basketSn"), "");

		tattooColor.setSEQ(Integer.parseInt(color));
		mav.addObject("tattooId", tattooId);
		mav.addObject("tattooName", tattooName);
		mav.addObject("tattoPrice", tattoPrice);
		mav.addObject("color", color);
		mav.addObject("colorName", tattooColorService.selectTattooColorOne(tattooColor).getCOLOR());
		mav.addObject("tattooist", tattooist);
		mav.addObject("tattooImage", tattooImage);
		mav.addObject("name", Aria.decrypt(name, secretKey));
		mav.addObject("email", email);
		mav.addObject("phone", phone);
		mav.addObject("realTattooPrice", realTattooPrice);
		mav.addObject("salePrice", salePrice);
		
		mav.addObject("basketSn", basketSn);
		mav.setViewName("tattoo_payment");
		return mav;
	}
	
	// 예약하기
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();	// session 객체 가져오기
		User user = (User) session.getAttribute("loginUser"); // session 가져옴
		ModelAndView mav = new ModelAndView();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String basketSn = StringUtils.defaultString(request.getParameter("basketSn"), "");
		String tattooName = StringUtils.defaultString(request.getParameter("tattooName"), "");
		String tattoPrice = StringUtils.defaultString(request.getParameter("tattoPrice"), "");
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String reserve_dt = StringUtils.defaultString(request.getParameter("reserve_dt"), "");
		String reserve_tm = StringUtils.defaultString(request.getParameter("reserve_tm"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		String name = StringUtils.defaultString(request.getParameter("name"), "");
		String email = StringUtils.defaultString(request.getParameter("email"), "");
		String tel = StringUtils.defaultString(request.getParameter("phone"), "");
		String paymentSn = new SimpleDateFormat("yyyyMMddHHmmssS").format(new Date()) + "yena";
		int price = Integer.parseInt(tattoPrice.replaceAll(",", ""));
		
		
		if(reserve_tm.length() == 1) {
			reserve_tm = "0" + reserve_tm;
		}
		
		Payment payment = new Payment();
		payment.setPAYMENT_SN(paymentSn);
		payment.setUSER_ID(user.getId());
		payment.setTATTOO_ID(tattooId);
		payment.setTATTOO_NM(tattooName);
		payment.setPRICE(price);
		payment.setCOLOR(color);
		payment.setRESERVED_DT(reserve_dt.replaceAll("-", "") + reserve_tm + "0000");
		payment.setTATTOOIST_NAME(tattooist);
		payment.setPAYMENT_CMPL_YN("N");
		paymentService.insertPayment(payment);
		
		Stl stl = new Stl();
		stl.setPAYMENT_SN(paymentSn);
		stl.setUSER_ID(user.getId());
		stl.setNAME(name);
		stl.setEMAIL(email);
		stl.setTEL(tel);
		stl.setSTL_MONEY(price);
		stlService.insertStl(stl);
		
		if(!basketSn.equals("")) {
			basketService.deleteBasket(basketSn);
		}
		
		mav.setViewName("jsonView");
		return mav;
	}
	

}

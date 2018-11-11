package com.yena.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.yena.shop.model.User;
import com.yena.shop.service.AccountService;

public class AccountController extends MultiActionController{
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("join");
	}
	
	// 회원가입
	public ModelAndView inserUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String reg_dtm = sdf.format(new Date());
		String upd_dtm = sdf.format(new Date());
		
		// 값 받아
		String id= StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = StringUtils.defaultString(request.getParameter("pass_wd "), "");
		String name= StringUtils.defaultString(request.getParameter("name"), "");
		String email = StringUtils.defaultString(request.getParameter("email"), "");
		String year = StringUtils.defaultString(request.getParameter("year"), "");
		String month = StringUtils.defaultString(request.getParameter("month"), "");
		String date = StringUtils.defaultString(request.getParameter("date"), "");
		String gender= StringUtils.defaultString(request.getParameter("gender"), "");
		String tel = StringUtils.defaultString(request.getParameter("tel"), "");
		String adult_yn= StringUtils.defaultString(request.getParameter("adult_yn"), "");
		
		User user = new User();
		user.setAdult_yn(adult_yn);
		user.setBirth(year + month + date);
		user.setEmail(email);
		user.setGender(gender);
		user.setId(id);
		user.setName(name);
		user.setPass_wd(pass_wd);
		user.setReg_dtm(reg_dtm);
		user.setTel(tel);
		user.setUpd_dtm(upd_dtm);
		user.setUse_yn("y");
		
		accountService.insertUser(user);
		
		return mav;
		

		
	}
}

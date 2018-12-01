package com.yena.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.service.AccountService;

public class LoginController extends MultiActionController{
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("login");
	}
	
	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = Aria.encrypt(StringUtils.defaultString(request.getParameter("pass_wd"),""), secretKey);
		
		User user = new User();
		user.setId(id);
		user.setPass_wd(pass_wd);
		
		User uesr = accountService.selectUserOne(user);
		
		
		return new ModelAndView("jsonView");

	}
	
	
}

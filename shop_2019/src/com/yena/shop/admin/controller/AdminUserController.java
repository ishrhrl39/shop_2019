package com.yena.shop.admin.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.service.AccountService;

public class AdminUserController extends MultiActionController{
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		User user = new User();
		user.setId(StringUtils.defaultString(request.getParameter("id"), ""));
		mav.addObject("user", accountService.selectUserOne(user));
		mav.setViewName("admin_user_popup");
		return mav;
	}
	
	public ModelAndView updatePassWd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Aria.setCharset("UTF-8");
		User user = new User();
		user.setId(StringUtils.defaultString(request.getParameter("id"), ""));
		user.setPass_wd(Aria.encrypt(StringUtils.defaultString(request.getParameter("pass_wd"), "")));
		
		int result = accountService.updateUser(user);
		mav.addObject("result", result);
		mav.setViewName("jsonView");
		return mav;
	}
}

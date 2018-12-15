package com.yena.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.service.AccountService;

public class MyPageController extends MultiActionController{
	
	private AccountService accountService;
	private String secretKey = Aria.getSecretKey();

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("myInfo");
	}
	
	// 각 유저 회원 정보 가져오기
	public ModelAndView selectMyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Aria.setCharset("UTF-8");
		
		String id = StringUtils.defaultString(request.getParameter("userId"), "");
		User user = new User();
		user.setId(id);
		
		user = accountService.selectUserOne(user);
		// 이름 복호화
		user.setName(Aria.decrypt(user.getName(), secretKey));  
		mav.addObject("user", user);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	// 회원정보 수정
	public ModelAndView updateMyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = StringUtils.defaultString(request.getParameter("user_email"), "");
		String tel = StringUtils.defaultString(request.getParameter("user_tel"), "");
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setEmail(email);
		user.setTel(tel);
		user.setId(((User)session.getAttribute("loginUser")).getId());
		
		accountService.updateUser(user);
		
		return new ModelAndView("jsonView");
		
	}
	
	// 비밀번호 페이지
	public ModelAndView pwdUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pwdUpdatePage");
	}
	
	// 비밀번호 수정
	public ModelAndView updatePwdInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pass_wd = StringUtils.defaultString(request.getParameter("newPwd"), "");
		Aria.setCharset("UTF-8");
		
		User user = new User();
		user.setPass_wd(Aria.encrypt(pass_wd,secretKey));
		// 세션으로 ID 가져오기
		user.setId(((User)request.getSession().getAttribute("loginUser")).getId());
		
		accountService.updateUser(user);
		
		return new ModelAndView("jsonView");
		
	}
	


}

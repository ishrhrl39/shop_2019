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

public class LoginController extends MultiActionController{
	
	private AccountService accountService;
	private int sessionTimeout;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("login");
	}
	
	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = Aria.encrypt(StringUtils.defaultString(request.getParameter("pass_wd"),""), secretKey);
		
		User user = new User();
		user.setId(id);
		user.setPass_wd(pass_wd);
		
		User object = accountService.selectUserOne(user);

		if(object == null){ // 아이디 or 비밀번호 존재하지 않으면
			mav.addObject("result", false);
		}else{ // 아이디와 비밀번호 존재하면
			mav.addObject("result", true);
			HttpSession session = request.getSession();	// session 객체 가져오기
			session.setAttribute("loginUser", object);	// session에 담을 항목
			session.setMaxInactiveInterval(sessionTimeout * (1000 * 60));// session 유지시간 (30 * 1분)
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	// 로그아웃
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		// session 초기화
		session.invalidate();
		mav.setViewName("redirect:/index.do");
		return mav;
	}
}

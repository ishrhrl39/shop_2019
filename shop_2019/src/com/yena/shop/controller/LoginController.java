package com.yena.shop.controller;

import javax.servlet.http.Cookie;
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
		ModelAndView mav = new ModelAndView("login");
		Cookie[] cookies = request.getCookies();
		String id = "";
		for(int i = 0 ; i<cookies.length; i++){ // 쿠키 배열을 반복문으로 돌린다.
			if(cookies[i].getName().equalsIgnoreCase("cookieId")){
				id = cookies[i].getValue();  // 쿠키의 값을 가져온다.
			}
		}
		mav.addObject("cookieId", id);
		return mav;
	}
	
	// 로그인
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = Aria.encrypt(StringUtils.defaultString(request.getParameter("pass_wd"),""), secretKey);
		String saveSession = StringUtils.defaultString(request.getParameter("saveSession"), "n");
		
		User user = new User();
		user.setId(id);
		user.setPass_wd(pass_wd);
		
		User object = accountService.selectUserOne(user);

		if(object == null){ // 아이디 or 비밀번호 존재하지 않으면
			mav.addObject("result", false);
		}else{ // 아이디와 비밀번호 존재하면
			mav.addObject("result", true);
			HttpSession session = request.getSession();	// session 객체 가져오기
			session.setAttribute("loginUser", object); // session에 담을 항목
			session.setMaxInactiveInterval(sessionTimeout * (1000 * 60)); // session 유지시간 (30 * 1분)
			
			// 아이디 저장선택시, 쿠키저장
			if(saveSession.equalsIgnoreCase("y")){
				Cookie cookie = new Cookie("cookieId", user.getId());
				cookie.setMaxAge(365*24*60*60);
				response.addCookie(cookie);
			}else{
				Cookie[] cookies = request.getCookies();      // 요청정보로부터 쿠키를 가져온다.
				for(int i = 0 ; i<cookies.length; i++){       // 쿠키 배열을 반복문으로 돌린다.
					cookies[i].setMaxAge(0);                  // 특정 쿠키를 더 이상 사용하지 못하게 하기 위해서는 
	
					// 쿠키의 유효시간을 만료시킨다.
					response.addCookie(cookies[i]);           // 해당 쿠키를 응답에 추가(수정)한다.
				}
			}
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

package com.yena.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
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
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String reg_dtm = sdf.format(new Date());
		String upd_dtm = sdf.format(new Date());
		
		// 입력될 목록들
		String id= StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = Aria.encrypt(StringUtils.defaultString(request.getParameter("pass_wd"), ""), secretKey);
		String name= StringUtils.defaultString(request.getParameter("name"), "");
		String email =StringUtils.defaultString(request.getParameter("email"), "");
		String year = StringUtils.defaultString(request.getParameter("year"), "");
		String month = StringUtils.defaultString(request.getParameter("month"), "");
		String date = StringUtils.defaultString(request.getParameter("date"), "");
		String gender= StringUtils.defaultString(request.getParameter("gender"), "");
		String tel = StringUtils.defaultString(request.getParameter("tel"), "");
		String adult_yn= StringUtils.defaultString(request.getParameter("adult_yn"), "N");
		
		User user = new User();
		user.setAdult_yn(adult_yn);
		user.setBirth(year + month + date);
		user.setEmail(email);
		user.setGender(gender);
		user.setId(id);
		user.setName(Aria.encrypt(name, secretKey));
		user.setPass_wd(pass_wd);
		user.setReg_dtm(reg_dtm);
		user.setTel(tel);
		user.setUpd_dtm(upd_dtm);
		user.setUse_yn("y");
		
		accountService.insertUser(user);
		
		mav.addObject("name", name);
		mav.setViewName("joinSuccess");
		return mav;
		
	}
	
	// 아이디 중복 체크
	public ModelAndView duplCheckId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id= StringUtils.defaultString(request.getParameter("id"), "");
		mav.setViewName("jsonView");
		if(accountService.duplCheckId(id) == 1){
			mav.addObject("result", "true");
			return mav;
		}
		mav.addObject("result", "false");
		return mav;
	}
	
	// 아이디, 비밀번호 찾기 화면
	public ModelAndView findlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("findInfo");
	}
		
	// 아이디 찾기
	public ModelAndView findId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		String name = StringUtils.defaultString(request.getParameter("name"), "");
		String birth = StringUtils.defaultString(request.getParameter("birth"), "");
		String tel = StringUtils.defaultString(request.getParameter("tel"), "");
		
		User user = new User();
		user.setBirth(birth);
		user.setName(Aria.encrypt(name,secretKey));
		user.setTel(tel);
		
		user = accountService.selectUserOne(user);
		
		if(user == null){
			mav.addObject("result", false);
		}else{
			mav.addObject("result", true);
			mav.addObject("user", user);
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	// 아이디, 비밀번호 보여주는 화면
	public ModelAndView findSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		mav.addObject("id", id);
		mav.setViewName("findSuccess");
		return mav;
	}
	
	
	public static void main(String[] args) throws Exception {
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		System.out.println(Aria.decrypt("518CDF386541F6541BACC823FC7ECBA4", secretKey));
	}
}

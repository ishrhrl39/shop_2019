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
	
	
	
	public static void main(String[] args) throws Exception {
		String secretKey = Aria.getSecretKey();
		Aria.setCharset("UTF-8");
		System.out.println(Aria.decrypt("950B3939FB3F235B694B72C75A50ED0F", secretKey));
	}
}

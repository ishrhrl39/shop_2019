package com.yena.shop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AdminIndexController extends MultiActionController{
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("관리자 페이지 접속");
		return new ModelAndView("admin_main");
	}
}

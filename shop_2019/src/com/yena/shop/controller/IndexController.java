package com.yena.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class IndexController extends MultiActionController{
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" 메인 접속  ");
		return new ModelAndView("main");
	}
}

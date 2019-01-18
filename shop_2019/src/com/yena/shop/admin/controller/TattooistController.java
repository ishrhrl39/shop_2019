package com.yena.shop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.tattoo.service.TattooistService;

public class TattooistController extends MultiActionController{
	
	TattooistService tattooistService;
	
	public void setTattooistService(TattooistService tattooistService) {
		this.tattooistService = tattooistService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("타투 담당자 관리 페이지 이동");
		return new ModelAndView("admin_tattooist");
	}
}

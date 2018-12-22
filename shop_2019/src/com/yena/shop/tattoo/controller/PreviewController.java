package com.yena.shop.tattoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PreviewController extends MultiActionController{
	

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("open tattoo content preview");
		return new ModelAndView("tattoo_preview");
	}

}

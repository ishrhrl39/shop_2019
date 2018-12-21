package com.yena.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.service.MenuService;

public class IndexController extends MultiActionController{
	
	MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}


	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("main");
	}
	
	
	public ModelAndView selectMenuList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("menuList", menuService.selectAllMenuList());
		mv.setViewName("jsonView");
		return mv;
	}
}

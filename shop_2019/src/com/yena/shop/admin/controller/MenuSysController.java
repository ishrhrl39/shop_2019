package com.yena.shop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.Menu;
import com.yena.shop.model.User;
import com.yena.shop.security.Aria;
import com.yena.shop.service.MenuService;

public class MenuSysController extends MultiActionController{
	
	MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}



	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("메뉴 관리페이지 접속");
		ModelAndView mav = new ModelAndView(); 
		
		mav.addObject("menu_list", menuService.selectMenu());
		mav.setViewName("admin_menu");
		return mav;
	}
	
	
	public ModelAndView insertMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Menu menu = new Menu();
		menu.setMenu_nm(StringUtils.defaultString(request.getParameter("menuNm"), ""));
		menu.setOrder_no(Integer.parseInt(StringUtils.defaultString(request.getParameter("orderNo"), "0")));
		
		menuService.insertMenu(menu);
		mav.addObject("menu", menuService.selectMenuOne(menu));
		mav.setViewName("jsonView");
		return mav;
	}
	
	public ModelAndView deleteMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int menuCd = Integer.parseInt(StringUtils.defaultString(request.getParameter("menuCd"), "0"));
		
		menuService.deleteMenu(menuCd);
		mav.setViewName("jsonView");
		return mav;
	}
	
}

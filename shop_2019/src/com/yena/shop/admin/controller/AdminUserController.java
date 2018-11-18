package com.yena.shop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.service.AccountService;
import com.yena.shop.util.PagingMap;

public class AdminUserController extends MultiActionController{
	
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int page = Integer.parseInt(StringUtils.defaultString(request.getParameter("page"), "1"));
		
		PagingMap pagingMap = new PagingMap();
		
		
		pagingMap.setLimit(100);
		pagingMap.setPage(page);
		pagingMap.setPageCount(10);
		pagingMap.setDataCount(accountService.selectTotalUserCount());
		pagingMap.setPaging();
		
		List userList = accountService.selectUser(pagingMap.getMap());
		mav.addObject("now", pagingMap.getPage());
		mav.addObject("paging", pagingMap.getMap());
		mav.addObject("userList", userList);
		mav.setViewName("admin_user");
		return mav;
	}
}

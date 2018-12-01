package com.yena.shop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.service.AccountService;
import com.yena.shop.service.LoginLogService;
import com.yena.shop.util.PagingMap;

public class AdminLoginLogController extends MultiActionController{
	
	private LoginLogService loginLogService;
	private int pageLimit;

	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}


	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int page = Integer.parseInt(StringUtils.defaultString(request.getParameter("page"), "1"));
		
		PagingMap pagingMap = new PagingMap();
		pagingMap.setLimit(pageLimit);
		pagingMap.setPage(page);
		pagingMap.setPageCount(10);
		pagingMap.setDataCount(loginLogService.selectTotalLoginLogCount());
		pagingMap.setPaging();
		
		List userList = loginLogService.selectLoginLog(pagingMap.getMap());
		mav.addObject("now", pagingMap.getPage());
		mav.addObject("paging", pagingMap.getMap());
		mav.addObject("loginLogList", userList);
		mav.setViewName("admin_login_log");
		return mav;
	}
}

package com.yena.shop.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.service.AccountService;
import com.yena.shop.util.PagingMap;

public class AdminUserListController extends MultiActionController{
	
	private AccountService accountService;
	private int pageLimit;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}


	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String mode = StringUtils.defaultString(request.getParameter("mode"), "N");
		int page = Integer.parseInt(StringUtils.defaultString(request.getParameter("page"), "1"));
		
		PagingMap pagingMap = new PagingMap();
		
		if(mode.equalsIgnoreCase("S")){	// Search
			pagingMap.put("searchColumn", StringUtils.defaultString(request.getParameter("searchColumn"), "id"));
			pagingMap.put("searchValue", StringUtils.defaultString(request.getParameter("searchValue"), ""));
		}
		
		pagingMap.setLimit(pageLimit);
		pagingMap.setPage(page);
		pagingMap.setPageCount(10);
		pagingMap.setDataCount(accountService.selectTotalUserCount(pagingMap.getMap()));
		pagingMap.setPaging();
		
		List userList = accountService.selectUser(pagingMap.getMap());
		mav.addObject("mode", mode);
		mav.addObject("now", pagingMap.getPage());
		mav.addObject("paging", pagingMap.getMap());
		mav.addObject("userList", userList);
		mav.setViewName("admin_user");
		return mav;
	}
	
	
	public ModelAndView selectUserCount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		PagingMap pagingMap = new PagingMap();
		pagingMap.put("searchColumn", StringUtils.defaultString(request.getParameter("searchColumn"), "id"));
		pagingMap.put("searchValue", StringUtils.defaultString(request.getParameter("searchValue"), ""));
		mav.addObject("count", accountService.selectTotalUserCount(pagingMap.getMap()));
		mav.setViewName("jsonView");
		return mav;
	}
	
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String[] userList = request.getParameterValues("user");
		for(String userId : userList){
			if(!userId.equals("")){
				User user = new User();
				user.setId(userId);
				user.setUse_yn("n");
				accountService.updateUser(user);
			}
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
	public ModelAndView useYesUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String[] userList = request.getParameterValues("user");
		for(String userId : userList){
			if(!userId.equals("")){
				User user = new User();
				user.setId(userId);
				user.setUse_yn("y");
				accountService.updateUser(user);
			}
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
}

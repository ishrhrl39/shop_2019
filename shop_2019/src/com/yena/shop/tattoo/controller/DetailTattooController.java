package com.yena.shop.tattoo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.TattooColorService;
import com.yena.shop.tattoo.service.TattooService;
import com.yena.shop.tattoo.service.TattooistService;

public class DetailTattooController extends MultiActionController{
	
	private TattooService tattooService;
	private TattooistService tattooistService;
	private TattooColorService tattooColorService;
	
	public void setTattooService(TattooService tattooService) {
		this.tattooService = tattooService;
	}
	public TattooistService getTattooistService() {
		return tattooistService;
	}
	public void setTattooistService(TattooistService tattooistService) {
		this.tattooistService = tattooistService;
	}
	

	// 타투 상품 자세히 보기
	public TattooColorService getTattooColorService() {
		return tattooColorService;
	}
	public void setTattooColorService(TattooColorService tattooColorService) {
		this.tattooColorService = tattooColorService;
	}
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		int id = Integer.parseInt(StringUtils.defaultString(request.getParameter("id"), "1"));

		Tattoo tattoo = tattooService.selectTattooOne(id);
		mav.addObject("one", tattoo);
		mav.addObject("tattooistList", tattooistService.selectTattooist());
		mav.addObject("tattooColorList", tattooColorService.selectTattooColor());
		mav.setViewName("tattoo_detail");
		return mav;
	}

}

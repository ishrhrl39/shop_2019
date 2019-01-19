package com.yena.shop.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.security.Aria;
import com.yena.shop.tattoo.model.TattooColor;
import com.yena.shop.tattoo.service.TattooColorService;

public class TattooColorController extends MultiActionController{
	
	TattooColorService tattooColorService;
	public void setTattooColorService(TattooColorService tattooColorService) {
		this.tattooColorService = tattooColorService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("타투 색상 관리 페이지 이동");
		List<TattooColor> tattooColorList = tattooColorService.selectTattooColor();
		System.out.println("size => " + tattooColorList.size());
		Map returnData = new HashMap();
		returnData.put("tattooColorList", tattooColorList);
		return new ModelAndView("admin_tattoo_color", returnData);
	}
	
	public ModelAndView addTattooColor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		TattooColor tattooColor = new TattooColor();
		tattooColor.setCOLOR(StringUtils.defaultString(request.getParameter("color"), ""));
		tattooColorService.insertTattooColor(tattooColor);
		mav.addObject("result", 1);
		mav.setViewName("jsonView");
		return mav;
	}

	public ModelAndView deleteTattooColor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Aria.setCharset("UTF-8");
		String [] seqList = request.getParameterValues("delete_seq");
		for(String seq : seqList) {
			System.out.println(seq);
			tattooColorService.deleteTattooColor(seq);
		}
		mav.addObject("result", 1);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView selectTattooColorOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String seq = StringUtils.defaultString(request.getParameter("seq"), "0");
		TattooColor tattooColor = new TattooColor();
		tattooColor.setSEQ(Integer.parseInt(seq));
		tattooColor = tattooColorService.selectTattooColorOne(tattooColor);
		mav.addObject("tattooColor", tattooColor);
		mav.setViewName("jsonView");
		return mav;
	}
	
}

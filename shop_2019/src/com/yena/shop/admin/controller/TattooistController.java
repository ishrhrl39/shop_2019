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
import com.yena.shop.tattoo.model.Tattooist;
import com.yena.shop.tattoo.service.TattooistService;

public class TattooistController extends MultiActionController{
	
	TattooistService tattooistService;
	
	public void setTattooistService(TattooistService tattooistService) {
		this.tattooistService = tattooistService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("타투 담당자 관리 페이지 이동");
		List<Tattooist> tattooistList = tattooistService.selectTattooist();
		Map returnData = new HashMap();
		returnData.put("tattooistList", tattooistList);
		return new ModelAndView("admin_tattooist", returnData);
	}
	
	public ModelAndView addTatooist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Tattooist tattooist = new Tattooist();
		tattooist.setNAME(StringUtils.defaultString(request.getParameter("name"), ""));
		tattooist.setCAREER(Integer.parseInt(StringUtils.defaultString(request.getParameter("career"), "0")));
		tattooistService.insertTattooist(tattooist);
		mav.addObject("result", 1);
		mav.setViewName("jsonView");
		return mav;
	}
	
	public ModelAndView updateTatooist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Tattooist tattooist = new Tattooist();
		String seq = StringUtils.defaultString(request.getParameter("seq"), "0");
		tattooist.setSEQ(Integer.parseInt(seq));
		tattooist.setNAME(StringUtils.defaultString(request.getParameter("name"), ""));
		tattooist.setCAREER(Integer.parseInt(StringUtils.defaultString(request.getParameter("career"), "0")));
		tattooistService.updateTattooist(tattooist);
		mav.addObject("result", 1);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView deleteTatooist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Aria.setCharset("UTF-8");
		String [] seqList = request.getParameterValues("delete_seq");
		for(String seq : seqList) {
			System.out.println(seq);
			tattooistService.deleteTattooist(seq);
		}
		mav.addObject("result", 1);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView selectTattooistOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String seq = StringUtils.defaultString(request.getParameter("seq"), "0");
		Tattooist tattooist = new Tattooist();
		tattooist.setSEQ(Integer.parseInt(seq));
		tattooist = tattooistService.selectTattooistOne(tattooist);
		mav.addObject("tattooist", tattooist);
		mav.setViewName("jsonView");
		return mav;
	}
	
}

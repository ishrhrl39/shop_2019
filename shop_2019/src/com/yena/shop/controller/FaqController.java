package com.yena.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.Faq;
import com.yena.shop.security.Aria;
import com.yena.shop.service.FaqService;
import com.yena.shop.tattoo.model.Tattooist;
import com.yena.shop.tattoo.service.TattooistService;

public class FaqController extends MultiActionController{
	
	FaqService faqService;

	public void setFaqService(FaqService faqService) {
		this.faqService = faqService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Faq> faqList = faqService.selectFaqList();
		Map returnData = new HashMap();
		for(int i=0; i<faqList.size(); i++) {
			Faq faq = faqList.get(i);
			faq.setCONTENT(faq.getCONTENT().replace("\r\n", "<br/>"));
			faqList.set(i, faq);
		}
		returnData.put("faqList", faqList);
		return new ModelAndView("faq", returnData);
	}
	
}

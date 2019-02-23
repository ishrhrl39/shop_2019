package com.yena.shop.admin.controller;

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

public class AdminFaqController extends MultiActionController{
	
	FaqService faqService;

	public void setFaqService(FaqService faqService) {
		this.faqService = faqService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Faq> faqList = faqService.selectFaqList();
		Map returnData = new HashMap();
		returnData.put("faqList", faqList);
		return new ModelAndView("admin_faq", returnData);
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		Faq faq = new Faq();
		faq.setTITLE(StringUtils.defaultString(request.getParameter("title"), ""));
		faq.setCONTENT(StringUtils.defaultString(request.getParameter("content"), "").replaceAll("\r\n", "<br/>"));
		faqService.insertFaq(faq);
		return new ModelAndView("jsonView", returnData);
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		Faq faq = new Faq();
		faq.setNO(Integer.parseInt(StringUtils.defaultString(request.getParameter("no"), "0")));
		faq.setTITLE(StringUtils.defaultString(request.getParameter("title"), ""));
		faq.setCONTENT(StringUtils.defaultString(request.getParameter("content"), ""));
		faqService.insertFaq(faq);
		return new ModelAndView("jsonView", returnData);
	}
	
	public ModelAndView deleteFaq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String[] faqList = request.getParameterValues("faqNo");
		
		for(String f : faqList) {
			if(f.equals("")) continue;
			int faqNo = Integer.parseInt(f);
			faqService.deleteFaq(faqNo);
		}
		return new ModelAndView("jsonView", returnData);
	}
	
	public ModelAndView updateFaq(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		int paramNo = Integer.parseInt(request.getParameter("paramNo"));
		
		System.out.println("update.faq.No => " + paramNo);
		String title = StringUtils.defaultString(request.getParameter("title_" + paramNo));
		String content = StringUtils.defaultString(request.getParameter("content_" + paramNo));
		
		System.out.println("update.title => " + title);
		System.out.println("update.content => " + content);
		
		Faq faq = new Faq();
		faq.setNO(paramNo);
		faq.setTITLE(title);
		faq.setCONTENT(content);
		faqService.updateFaq(faq);
		
		return new ModelAndView("jsonView", returnData);
	}
	
	public ModelAndView selectOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		returnData.put("faq", faqService.selectFaqOne(Integer.parseInt(StringUtils.defaultString(request.getParameter("no"), "0"))));
		return new ModelAndView("jsonView", returnData);
	}
}

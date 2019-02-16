package com.yena.shop.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.User;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.security.Aria;
import com.yena.shop.service.AccountService;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;
import com.yena.shop.tattoo.service.PaymentService;
import com.yena.shop.tattoo.service.StlService;

public class StlController extends MultiActionController{
	
	private StlService stlService;
	private PaymentService paymentService;
	private String secretKey = Aria.getSecretKey();
	private int pageLimit;
	
	
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public void setStlService(StlService stlService) {
		this.stlService = stlService;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String searchColumn = StringUtils.defaultString(request.getParameter("searchColumn"), "");
		String searchValue = StringUtils.defaultString(request.getParameter("searchValue"), "");
		int page = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("page"), "1"));
		
		Page pageVo = new Page();
		
		int offset = (page - 1) * pageLimit;
		int maxPage = 0;
		HttpSession session = request.getSession();	// session 객체 가져오기
		User user = (User) session.getAttribute("loginUser");
		
		pageVo.setUserId(user.getId());
		pageVo.setNowPage(page);
		pageVo.setLimit(pageLimit);
		// 각 페이지당 첫 번호(인덱스)
		pageVo.setOffset(offset);
		pageVo.setPageNumCnt(10);
		int start = 0;
		int end = 0;
		
		// 페이지 번호 시작 및 끝 번호 설정
		if(page % pageVo.getPageNumCnt() > 0){   //		x % 10가 0이 아닌 경우
			start = (page / pageVo.getPageNumCnt()) * pageVo.getPageNumCnt() + 1;
		}else{   //		x % 10가 0인경우
			start = ((page-1) / pageVo.getPageNumCnt()) * pageVo.getPageNumCnt() + 1;
		}
		end = start + pageVo.getPageNumCnt() - 1;
		
		// 검색어가 들어왔으니 검색모드
		if(!searchValue.equals("")){
			pageVo.setSearchKey(searchColumn);
			pageVo.setSearchValue(searchValue);
		}
		
		// 전체 목록 및 개수 
		List stlList = stlService.selectStlList(pageVo);
		int count = stlService.selectTotalStl(pageVo); 
		
		// 페이지 번호 최대값
		maxPage = count / pageLimit;
		if(count % pageLimit > 0){
			maxPage = maxPage + 1;
		}
		pageVo.setMaxPage(maxPage);
		
		// 페이지 번호 최대값이 계산한 페이지 끝번호보다 작을 때
		if(pageVo.getMaxPage() < end){
			end = pageVo.getMaxPage();
		}
		
		pageVo.setStart(start);
		pageVo.setEnd(end);
		
		if(pageVo.getSearchKey() != null){
			returnData.put("searchKey", pageVo.getSearchKey());
			returnData.put("searchValue", pageVo.getSearchValue());
		}
		

		returnData.put("pageVo", pageVo);
		returnData.put("list", stlList);
		return new ModelAndView("admin_stl", returnData);
	}
	
	
	public ModelAndView updateStlSts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String paymentSn = StringUtils.defaultString(request.getParameter("paymentSn"), "");
		Payment payment = new Payment();
		payment.setPAYMENT_SN(paymentSn);
		payment.setPAYMENT_CMPL_YN(StringUtils.defaultString(request.getParameter("cmpl_yn"), "N").toUpperCase());
		
		paymentService.updatePaymentCmplYn(payment);
		
		return new ModelAndView("jsonView", returnData);
	}
}
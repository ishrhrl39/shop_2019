package com.yena.shop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.Basket;
import com.yena.shop.model.User;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.security.Aria;
import com.yena.shop.service.AccountService;
import com.yena.shop.service.BasketService;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.TattooColor;
import com.yena.shop.tattoo.service.PaymentService;
import com.yena.shop.tattoo.service.StlService;
import com.yena.shop.tattoo.service.TattooColorService;

public class BasketController extends MultiActionController{
	
	private StlService stlService;
	private BasketService basketService;
	private TattooColorService tattooColorService;
	private String secretKey = Aria.getSecretKey();
	private int pageLimit;
	
	public void setStlService(StlService stlService) {
		this.stlService = stlService;
	}
	
	public void setBasketService(BasketService basketService) {
		this.basketService = basketService;
	}


	public void setTattooColorService(TattooColorService tattooColorService) {
		this.tattooColorService = tattooColorService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(); // session 객체 가져오기
		User user = (User) session.getAttribute("loginUser");// session 가져옴
		String id = user.getId();
		
		List<Basket> list = basketService.selectBasket(id);
		System.out.println("사이즈 : " +list.size());
		mav.addObject("list", list);
		mav.setViewName("shopBasket");
		
		return mav;

	}
	
	// 장바구니 테이블에 삽입
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(); // session 객체 가져오기
		User user = (User) session.getAttribute("loginUser");// session 가져옴
		
		String id = user.getId();
		int tattooId = Integer.parseInt(StringUtils.defaultString(request.getParameter("tattooId"), "1"));
		String color = StringUtils.defaultString(request.getParameter("color"), "");
		String tattooist = StringUtils.defaultString(request.getParameter("tattooist"), "");
		// 색상 테이블에서 색상 가져오기
		TattooColor tattooColor = new TattooColor();
		tattooColor.setSEQ(Integer.parseInt(color));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String reqDtm = sdf.format(new Date());
		
		
		Basket basket = new Basket();
		basket.setUSER_ID(id);
		basket.setTATTOO_ID(tattooId);
		basket.setCOLOR(tattooColorService.selectTattooColorOne(tattooColor).getCOLOR());
		basket.setTATTOOIST_NAME(tattooist);
		basket.setREG_DTM(reqDtm);
		basket.setUPD_DTM(reqDtm);
		
		basketService.insertBasket(basket);
		mav.setViewName("jsonView");
		return mav;
	}
	
//	public static void main(String[] args) {
//		Map returnData = new HashMap();
//		String searchColumn = StringUtils.defaultString(request.getParameter("searchColumn"), "");
//		String searchValue = StringUtils.defaultString(request.getParameter("searchValue"), "");
//		int page = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("page"), "1"));
//		
//		Page pageVo = new Page();
//		
//		int offset = (page - 1) * pageLimit;
//		int maxPage = 0;
//		HttpSession session = request.getSession();	// session 객체 가져오기
//		User user = (User) session.getAttribute("loginUser");
//		
//		pageVo.setUserId(user.getId());
//		pageVo.setNowPage(page);
//		pageVo.setLimit(pageLimit);
//		// 각 페이지당 첫 번호(인덱스)
//		pageVo.setOffset(offset);
//		pageVo.setPageNumCnt(10);
//		int start = 0;
//		int end = 0;
//		
//		// 페이지 번호 시작 및 끝 번호 설정
//		if(page % pageVo.getPageNumCnt() > 0){   //		x % 10가 0이 아닌 경우
//			start = (page / pageVo.getPageNumCnt()) * pageVo.getPageNumCnt() + 1;
//		}else{   //		x % 10가 0인경우
//			start = ((page-1) / pageVo.getPageNumCnt()) * pageVo.getPageNumCnt() + 1;
//		}
//		end = start + pageVo.getPageNumCnt() - 1;
//		
//		// 검색어가 들어왔으니 검색모드
//		if(!searchValue.equals("")){
//			pageVo.setSearchKey(searchColumn);
//			pageVo.setSearchValue(searchValue);
//		}
//		
//		// 전체 목록 및 개수 
//		List stlList = stlService.selectStlList(pageVo);
//		int count = stlService.selectTotalStl(pageVo); 
//		
//		// 페이지 번호 최대값
//		maxPage = count / pageLimit;
//		if(count % pageLimit > 0){
//			maxPage = maxPage + 1;
//		}
//		pageVo.setMaxPage(maxPage);
//		
//		// 페이지 번호 최대값이 계산한 페이지 끝번호보다 작을 때
//		if(pageVo.getMaxPage() < end){
//			end = pageVo.getMaxPage();
//		}
//		
//		pageVo.setStart(start);
//		pageVo.setEnd(end);
//		
//		if(pageVo.getSearchKey() != null){
//			returnData.put("searchKey", pageVo.getSearchKey());
//			returnData.put("searchValue", pageVo.getSearchValue());
//		}
//		
//
//		returnData.put("pageVo", pageVo);
//		returnData.put("list", stlList);
//		return new ModelAndView("myInfo_basket", returnData);
//	}
}

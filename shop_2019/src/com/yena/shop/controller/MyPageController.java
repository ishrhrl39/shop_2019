package com.yena.shop.controller;

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
import com.yena.shop.tattoo.service.PaymentService;

public class MyPageController extends MultiActionController{
	
	private AccountService accountService;
	private PaymentService paymentService;
	private String secretKey = Aria.getSecretKey();
	private int pageLimit;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}



	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("myInfo");
	}
	
	// 회원탈퇴 페이지
	public ModelAndView drop(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		returnData.put("withDrawList", accountService.selectWithDraw());
		return new ModelAndView("account_drop", returnData);
	}
	
	// 각 유저 회원 정보 가져오기
	public ModelAndView selectMyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Aria.setCharset("UTF-8");
		
		String id = StringUtils.defaultString(request.getParameter("userId"), "");
		User user = new User();
		user.setId(id);
		
		user = accountService.selectUserOne(user);
		// 이름 복호화
		user.setName(Aria.decrypt(user.getName(), secretKey));  
		mav.addObject("user", user);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	// 회원정보 수정
	public ModelAndView updateMyInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = StringUtils.defaultString(request.getParameter("user_email"), "");
		String tel = StringUtils.defaultString(request.getParameter("user_tel"), "");
		HttpSession session = request.getSession();
		
		User user = new User();
		user.setEmail(email);
		user.setTel(tel);
		user.setId(((User)session.getAttribute("loginUser")).getId());
		
		accountService.updateUser(user);
		
		return new ModelAndView("jsonView");
		
	}
	
	// 비밀번호 페이지
	public ModelAndView pwdUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("pwdUpdatePage");
	}
	
	// 비밀번호 수정
	public ModelAndView updatePwdInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pass_wd = StringUtils.defaultString(request.getParameter("newPwd"), "");
		Aria.setCharset("UTF-8");
		
		User user = new User();
		user.setPass_wd(Aria.encrypt(pass_wd,secretKey));
		// 세션으로 ID 가져오기
		user.setId(((User)request.getSession().getAttribute("loginUser")).getId());
		
		accountService.updateUser(user);
		
		return new ModelAndView("jsonView");
		
	}
	
	// 회원탈퇴
	public ModelAndView withDraw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		
		String id = StringUtils.defaultString(request.getParameter("id"), "");
		String pass_wd = StringUtils.defaultString(request.getParameter("pass_wd"), "");
		User user = new User();
		user.setPass_wd(Aria.encrypt(pass_wd,secretKey));
		// 세션으로 ID 가져오기
		user.setId(id);
		
		if(accountService.selectUserOne(user) == null) {
			returnData.put("result", "NOUSER");
		}else {
			user.setUse_yn("n");
			WithDrawLog withDrawLog = new WithDrawLog();
			withDrawLog.setWithdraw_cd(StringUtils.defaultString(request.getParameter("withdraw_comment"), "A"));
			withDrawLog.setId(user.getId());
			
			accountService.updateUser(user);
			accountService.insertWithdrawLog(withDrawLog);
			returnData.put("result", "SUCCESS");
		}
		
		return new ModelAndView("jsonView", returnData);
	}
	
	// 구매이력
	public ModelAndView payment(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String tmpSearchValue = StringUtils.defaultString(request.getParameter("tmpSearchValue"), "");
		String tmpSearchKey = StringUtils.defaultString(request.getParameter("tmpSearchKey"), "");
		String tattoo_nm = StringUtils.defaultString(request.getParameter("tattoo_nm"), "");
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
		if(!tattoo_nm.equals("")){
			pageVo.setSearchKey("TATTOO_NM");
			pageVo.setSearchValue(tattoo_nm);
		}else if(!tmpSearchValue.equals("")){
			pageVo.setSearchKey(tmpSearchKey);
			pageVo.setSearchValue(tmpSearchValue);
		}
		
		// 전체 목록 및 개수 
		List paymentList = paymentService.selectPaymentList(pageVo);
		int count = paymentService.selectTotalPayment(pageVo); 
		
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
		returnData.put("tattoo_nm", tattoo_nm);
		returnData.put("list", paymentList);
		return new ModelAndView("myInfo_payment", returnData);
	}
}

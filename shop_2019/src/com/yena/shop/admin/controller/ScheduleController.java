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
import com.yena.shop.tattoo.model.TattooSchedule;
import com.yena.shop.tattoo.service.PaymentService;
import com.yena.shop.tattoo.service.ScheduleService;
import com.yena.shop.tattoo.service.StlService;

public class ScheduleController extends MultiActionController{
	
	private ScheduleService scheduleService;
	
	
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		Map param = new HashMap();
		String searchKey = StringUtils.defaultIfEmpty(request.getParameter("searchKey"), "");
		String searchValue = StringUtils.defaultIfEmpty(request.getParameter("searchValue"), "");
		

		if(!searchValue.equals("")) {
			System.out.println("search => " + searchKey + ":" + searchValue);
			param.put("searchKey", searchKey);
			param.put("searchValue", searchValue);
		}
		
		List scheduleList = scheduleService.selectScheduleList(param);
		returnData.put("scheduleList", scheduleList);
		return new ModelAndView("admin_schedule", returnData);
	}
	
	public ModelAndView deleteSchdule(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Aria.setCharset("UTF-8");
		String [] keyList = request.getParameterValues("delete_key");
		for(String key : keyList) {
			String[] keys = key.split(",");
			TattooSchedule schedule = new TattooSchedule();
			schedule.setRESERVED_DATE(keys[0]);
			schedule.setRESERVED_HOUR(keys[1]);
			schedule.setTATTOO_NAME(keys[2]);
			scheduleService.deleteSchedule(schedule);
		}
		mav.setViewName("jsonView");
		return mav;
	}
	
}

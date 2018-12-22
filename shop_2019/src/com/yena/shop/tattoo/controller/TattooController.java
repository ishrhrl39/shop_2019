package com.yena.shop.tattoo.controller;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.TattooService;

public class TattooController extends MultiActionController{
	
	private TattooService tattooService;
	private String imageUploadPath;

	public void setImageUploadPath(String imageUploadPath) {
		this.imageUploadPath = imageUploadPath;
	}

	public void setTattooService(TattooService tattooService) {
		this.tattooService = tattooService;
	}

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String goods = StringUtils.defaultString(request.getParameter("goods"));
		
		Map param = new HashMap();
		param.put("goods", goods);
		returnData.put("goods", goods);
		List tattooList = tattooService.selectTattooList(param);
		returnData.put("list", tattooList);
		return new ModelAndView("tattoo_list", returnData);
	}

	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		Map param = new HashMap();
		returnData.put("goods", StringUtils.defaultString(request.getParameter("goods")));
		return new ModelAndView("tattoo_insert", returnData);
	}
	
	public void insertProc(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		Map param = new HashMap();
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024*1024*15;
		String savePath = imageUploadPath + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date());
		
		File dir = new File(savePath);
		
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
		Tattoo tattoo = new Tattoo();
		
		// 참조 : http://zero-gravity.tistory.com/168
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		String fileName = multi.getFilesystemName("image");
		tattoo.setGoods(StringUtils.defaultString(multi.getParameter("goods")));
		tattoo.setNm(StringUtils.defaultString(multi.getParameter("nm")));
		tattoo.setImage(savePath + "/" + fileName);
		tattoo.setPrice(Integer.parseInt(StringUtils.defaultString(multi.getParameter("price"), "0")));
		tattoo.setColor(StringUtils.defaultString(multi.getParameter("color_list")));
		tattoo.setSale(Integer.parseInt(StringUtils.defaultString(multi.getParameter("sale"), "0")));
		tattoo.setSale_start_dt(StringUtils.defaultString(multi.getParameter("sale_start_dt")).replaceAll("-", ""));
		tattoo.setSale_end_dt(StringUtils.defaultString(multi.getParameter("sale_end_dt")).replaceAll("-", ""));
		tattoo.setContent(StringUtils.defaultString(multi.getParameter("content"), ""));
		tattooService.insertTattoo(tattoo);
		
		String url = "/tattoo/list.do?cmd=insert&goods=" + tattoo.getGoods();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('상품이 등록 되었습니다'); location.href = '" + url + "';</script>");
		out.flush();
	}
	
}

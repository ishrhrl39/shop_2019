package com.yena.shop.tattoo.controller;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.service.TattooService;

public class TattooController extends MultiActionController{
	
	private TattooService tattooService;
	private String imageUploadPath;
	private int pageLimit;
	
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public void setImageUploadPath(String imageUploadPath) {
		this.imageUploadPath = imageUploadPath;
	}

	public void setTattooService(TattooService tattooService) {
		this.tattooService = tattooService;
	}
	

	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map returnData = new HashMap();
		String goods = StringUtils.defaultString(request.getParameter("goods"));
		String nm = StringUtils.defaultString(request.getParameter("nm"), "");
		String tmpSearchValue = StringUtils.defaultString(request.getParameter("tmpSearchValue"), "");
		String tmpSearchKey = StringUtils.defaultString(request.getParameter("tmpSearchKey"), "");
		
		int page = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("page"), "1"));
		
		Page pageVo = new Page();
		
		int offset = (page - 1) * pageLimit;
		int maxPage = 0;
		pageVo.setGoods(goods);
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
		if(!nm.equals("")){
			pageVo.setSearchKey("NM");
			pageVo.setSearchValue(nm);
		}else if(!tmpSearchValue.equals("")){
			pageVo.setSearchKey(tmpSearchKey);
			pageVo.setSearchValue(tmpSearchValue);
		}
		
		// 전체 목록 및 개수 
		List tattooList = tattooService.selectTattooList(pageVo);
		int count = tattooService.selectTotalTattoo(pageVo); 
		
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
		returnData.put("goods", goods);
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
		String dirName = "/images/upload" + File.separator + new SimpleDateFormat("yyyyMMdd").format(new Date());
//		String savePath = this.getServletContext().getRealPath("/")+ dirName;
		String savePath = imageUploadPath + dirName;
		
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
		tattoo.setImage(dirName + "/" + fileName);
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

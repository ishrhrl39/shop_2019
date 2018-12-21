package com.yena.shop.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yena.shop.model.Menu;
import com.yena.shop.model.SubMenu;
import com.yena.shop.service.MenuService;

public class MenuSysController extends MultiActionController{
	
	MenuService menuService;
	
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}



	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("메뉴 관리페이지 접속");
		ModelAndView mav = new ModelAndView(); 
		
		mav.addObject("menu_list", menuService.selectMenu());
		mav.setViewName("admin_menu");
		return mav;
	}
	
	/**
	 * 서브 메뉴목록 조회
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectSubMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(); 
		int menuCd = Integer.parseInt(StringUtils.defaultString(request.getParameter("menuCd"), "0"));
		mav.addObject("subMenuList", menuService.selectSubMenu(menuCd));
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	/**
	 * 그룹 메뉴 등록
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView insertMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Menu menu = new Menu();
		menu.setMenu_nm(StringUtils.defaultString(request.getParameter("menuNm"), ""));
		menu.setOrder_no(Integer.parseInt(StringUtils.defaultString(request.getParameter("orderNo"), "0")));
		menu.setLink_url(StringUtils.defaultString(request.getParameter("link_url"), ""));
		
		menuService.insertMenu(menu);
		mav.addObject("menu", menuService.selectMenuOne(menu));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 서브 메뉴 등록
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView insertSubMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		SubMenu subMenu = new SubMenu();
		subMenu.setSub_menu_cd(String.valueOf(menuService.selectMaxSubMenuCd() + 1));
		subMenu.setMenu_cd(Integer.parseInt(StringUtils.defaultString(request.getParameter("menuCd"), "0")));
		subMenu.setSub_menu_nm(StringUtils.defaultString(request.getParameter("subMenuNm"), ""));
		subMenu.setOrder_no(Integer.parseInt(StringUtils.defaultString(request.getParameter("subOrderNo"), "0")));
		subMenu.setLink_url(StringUtils.defaultString(request.getParameter("sub_link_url"), ""));
		subMenu.setUser_auth("S");
		subMenu.setUse_yn("Y");
		menuService.insertSubMenu(subMenu);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView deleteMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int menuCd = Integer.parseInt(StringUtils.defaultString(request.getParameter("menuCd"), "0"));
		
		menuService.deleteMenu(menuCd);
		mav.setViewName("jsonView");
		return mav;
	}
	
	public ModelAndView deleteSubMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int menuCd = Integer.parseInt(StringUtils.defaultString(request.getParameter("menuCd"), "0"));
		String subMenuCd = StringUtils.defaultString(request.getParameter("subMenuCd"), "0");
		
		SubMenu subMenu = new SubMenu();
		subMenu.setMenu_cd(menuCd);
		subMenu.setSub_menu_cd(subMenuCd);
		
		menuService.deleteSubMenu(subMenu);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView updateMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Menu menu = new Menu();
		menu.setMenu_nm(StringUtils.defaultString(request.getParameter("popup_menuNm"), ""));
		menu.setMenu_cd(Integer.parseInt(StringUtils.defaultString(request.getParameter("popup_menuCd"), "0")));
		menu.setLink_url(StringUtils.defaultString(request.getParameter("popup_menuUrl"), ""));
		logger.info("update menu => " + menu.getMenu_cd());
		menuService.updateMenu(menu);
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 서브메뉴 수정
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateSubMenu(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		SubMenu menu = new SubMenu();
		menu.setMenu_cd(Integer.parseInt(StringUtils.defaultString(request.getParameter("popup_menuCd"), "0")));
		menu.setSub_menu_cd(StringUtils.defaultString(request.getParameter("popup_subMenuCd"), "0"));
		menu.setSub_menu_nm(StringUtils.defaultString(request.getParameter("popup_subMenuNm"), ""));
		menu.setLink_url(StringUtils.defaultString(request.getParameter("popup_subMenuUrl"), ""));
		logger.info("update subMenu => " + menu.getMenu_cd());
		menuService.updateSubMenu(menu);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	/**
	 * 메뉴 순서 저장
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateMenuOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String items = StringUtils.defaultString(request.getParameter("items"), "");
		
		if(!items.equals("")) {
			if(items.indexOf(",") > -1) {
				String[] menuCdList = items.split(",");
				int order = 1;
				for(String menuCd : menuCdList) {
					Menu menu = new Menu();
					menu.setMenu_cd(Integer.parseInt(menuCd));
					menu.setOrder_no(order);
					menuService.updateMenu(menu);
					order++;
				}
			}else {
				Menu menu = new Menu();
				menu.setMenu_cd(Integer.parseInt(items));
				menu.setOrder_no(1);
				menuService.updateMenu(menu);
			}
		}

		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 서브 메뉴 순서 저장
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView updateSubMenuOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		String items = StringUtils.defaultString(request.getParameter("items"), "");
		String menu_cd = StringUtils.defaultString(request.getParameter("menu_cd"), "");
		
		if(!items.equals("")) {
			if(items.indexOf(",") > -1) {
				String[] menuCdList = items.split(",");
				int order = 1;
				for(String subMenuCd : menuCdList) {
					SubMenu menu = new SubMenu();
					menu.setMenu_cd(Integer.parseInt(menu_cd));
					menu.setSub_menu_cd(subMenuCd);
					menu.setOrder_no(order);
					menuService.updateSubMenu(menu);
					order++;
				}
			}else {
				SubMenu menu = new SubMenu();
				menu.setMenu_cd(Integer.parseInt(menu_cd));
				menu.setSub_menu_cd(items);
				menu.setOrder_no(1);
				menuService.updateSubMenu(menu);
			}
		}

		mav.setViewName("jsonView");
		return mav;
	}
	
	
	public ModelAndView selectMenuOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		Menu menu = new Menu();
		menu.setMenu_cd(Integer.parseInt(StringUtils.defaultString(request.getParameter("menu_cd"), "0")));
		mav.addObject("menu", menuService.selectMenuOne(menu));
		mav.setViewName("jsonView");
		return mav;
	}
	
	/**
	 * 서브 메뉴 1개 조회
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView selectSubMenuOne(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		SubMenu subMenu = new SubMenu();
		subMenu.setMenu_cd(Integer.parseInt(StringUtils.defaultString(request.getParameter("menu_cd"), "0")));
		subMenu.setSub_menu_cd(StringUtils.defaultString(request.getParameter("sub_menu_cd"), "0"));
		mav.addObject("menu", menuService.selectSubMenuOne(subMenu));
		mav.setViewName("jsonView");
		return mav;
	}
	
}

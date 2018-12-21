package com.yena.shop.model;

public class SubMenu {
	private int menu_cd;	// 그룹메뉴 id
	private String sub_menu_cd;		// 서브메뉴 id
	private String sub_menu_nm;		// 서브메뉴명
	private String user_auth;		// 계정권한
	private String use_yn;		// 사용여부
	private String reg_dtm;		// 등록일자
	private String upd_dtm;		// 수정일자
	private int order_no;	// 메뉴 순서
	private String link_url;	// 링크
	
	
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public int getMenu_cd() {
		return menu_cd;
	}
	public void setMenu_cd(int menu_cd) {
		this.menu_cd = menu_cd;
	}
	public String getSub_menu_cd() {
		return sub_menu_cd;
	}
	public void setSub_menu_cd(String sub_menu_cd) {
		this.sub_menu_cd = sub_menu_cd;
	}
	public String getSub_menu_nm() {
		return sub_menu_nm;
	}
	public void setSub_menu_nm(String sub_menu_nm) {
		this.sub_menu_nm = sub_menu_nm;
	}
	public String getUser_auth() {
		return user_auth;
	}
	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public String getReg_dtm() {
		return reg_dtm;
	}
	public void setReg_dtm(String reg_dtm) {
		this.reg_dtm = reg_dtm;
	}
	public String getUpd_dtm() {
		return upd_dtm;
	}
	public void setUpd_dtm(String upd_dtm) {
		this.upd_dtm = upd_dtm;
	}
	
	
}

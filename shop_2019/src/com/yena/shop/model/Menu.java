package com.yena.shop.model;

public class Menu {
	private int menu_cd;	// 그룹메뉴ID
	private String menu_nm;		//그룹메뉴명
	private String reg_dtm;		// 등록일자
	private String upd_dtm;		// 수정일자
	private int order_no;	// 메뉴 순서
	
	
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
	public String getMenu_nm() {
		return menu_nm;
	}
	public void setMenu_nm(String menu_nm) {
		this.menu_nm = menu_nm;
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

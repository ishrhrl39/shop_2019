package com.yena.shop.model;

public class LoginLog {
	private String id;	// 회원 아이디
	private String login_dt;	// 로그인 일자
	private String login_tm;	// 로그인 시간
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin_dt() {
		return login_dt;
	}
	public void setLogin_dt(String login_dt) {
		this.login_dt = login_dt;
	}
	public String getLogin_tm() {
		return login_tm;
	}
	public void setLogin_tm(String login_tm) {
		this.login_tm = login_tm;
	}
	
	
}

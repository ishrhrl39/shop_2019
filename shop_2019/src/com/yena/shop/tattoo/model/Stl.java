package com.yena.shop.tattoo.model;

/**
 * 무통장 입금
 * @author 이현섭
 *
 */
public class Stl {
	private int STL_NO;		// 결제번호
	private int PAYMENT_SN;	// 구매번호
	private String USER_ID;	// 사용자 ID
	private String TEL;		// 연락처
	private int STL_MONEY;	// 결제금액
	private String STL_DTM;	// 결제신청일자
	
	
	public int getSTL_NO() {
		return STL_NO;
	}
	public void setSTL_NO(int sTL_NO) {
		STL_NO = sTL_NO;
	}
	public int getPAYMENT_SN() {
		return PAYMENT_SN;
	}
	public void setPAYMENT_SN(int pAYMENT_SN) {
		PAYMENT_SN = pAYMENT_SN;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public int getSTL_MONEY() {
		return STL_MONEY;
	}
	public void setSTL_MONEY(int sTL_MONEY) {
		STL_MONEY = sTL_MONEY;
	}
	public String getSTL_DTM() {
		return STL_DTM;
	}
	public void setSTL_DTM(String sTL_DTM) {
		STL_DTM = sTL_DTM;
	}
	
	
}

package com.yena.shop.tattoo.model;

/**
 * 무통장 입금
 * @author 이현섭
 *
 */
/**
 * @author 한예나
 *
 */
public class Stl {
	private int STL_NO;
	private String PAYMENT_SN;
	private String USER_ID;
	private String NAME;
	private String TEL;
	private String EMAIL;
	private int STL_MONEY;
	private String STL_DTM;
	private String PAYMENT_CMPL_YN;	// 결제확정여부(N: 미확정, Y:확정)
	
	
	public String getPAYMENT_CMPL_YN() {
		return PAYMENT_CMPL_YN;
	}
	public void setPAYMENT_CMPL_YN(String pAYMENT_CMPL_YN) {
		PAYMENT_CMPL_YN = pAYMENT_CMPL_YN;
	}
	public int getSTL_NO() {
		return STL_NO;
	}
	public void setSTL_NO(int sTL_NO) {
		STL_NO = sTL_NO;
	}
	
	public String getPAYMENT_SN() {
		return PAYMENT_SN;
	}
	public void setPAYMENT_SN(String pAYMENT_SN) {
		PAYMENT_SN = pAYMENT_SN;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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

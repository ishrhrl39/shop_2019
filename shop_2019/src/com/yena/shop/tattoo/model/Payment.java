package com.yena.shop.tattoo.model;

/**
 * 구매내역
 * @author 이현섭
 *
 */
public class Payment {
	private int PAYMENT_SN;			// 구매번호
	private String USER_ID;			// 사용자 id
	private int TATTOO_ID;    		// 상품 번호
	private String TATTOO_NM;		// 상품명
	private int PRICE;				// 가격
	private String COLOR;			// 상품 색상
	private String TATTOOIST_NAME;	// 담당자명
	private String PAYMENT_CMPL_YN;	// 결제확정여부(N: 미확정, Y:확정)
	private String REG_DTM;			// 구매등록날짜
	private String UPD_DTM;			// 구매수정날짜
	
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
	public int getTATTOO_ID() {
		return TATTOO_ID;
	}
	public void setTATTOO_ID(int tATTOO_ID) {
		TATTOO_ID = tATTOO_ID;
	}
	public String getTATTOO_NM() {
		return TATTOO_NM;
	}
	public void setTATTOO_NM(String tATTOO_NM) {
		TATTOO_NM = tATTOO_NM;
	}
	public int getPRICE() {
		return PRICE;
	}
	public void setPRICE(int pRICE) {
		PRICE = pRICE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public String getTATTOOIST_NAME() {
		return TATTOOIST_NAME;
	}
	public void setTATTOOIST_NAME(String tATTOOIST_NAME) {
		TATTOOIST_NAME = tATTOOIST_NAME;
	}
	public String getPAYMENT_CMPL_YN() {
		return PAYMENT_CMPL_YN;
	}
	public void setPAYMENT_CMPL_YN(String pAYMENT_CMPL_YN) {
		PAYMENT_CMPL_YN = pAYMENT_CMPL_YN;
	}
	public String getREG_DTM() {
		return REG_DTM;
	}
	public void setREG_DTM(String rEG_DTM) {
		REG_DTM = rEG_DTM;
	}
	public String getUPD_DTM() {
		return UPD_DTM;
	}
	public void setUPD_DTM(String uPD_DTM) {
		UPD_DTM = uPD_DTM;
	}
	
	
}

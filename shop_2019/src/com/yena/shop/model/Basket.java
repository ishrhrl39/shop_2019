package com.yena.shop.model;

import com.yena.shop.tattoo.model.Tattoo;

/**
 * 장바구니 내역
 * @author 한예나
 *
 */
public class Basket extends Tattoo{
	private String BASKET_SN;
	private String USER_ID;
	private int TATTOO_ID;
	private String COLOR;
	private String TATTOOIST_NAME;
	private String REG_DTM;
	private String UPD_DTM;
	
	public String getBASKET_SN() {
		return BASKET_SN;
	}
	public void setBASKET_SN(String bASKET_SN) {
		BASKET_SN = bASKET_SN;
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

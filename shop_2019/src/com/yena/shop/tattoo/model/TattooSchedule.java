package com.yena.shop.tattoo.model;

public class TattooSchedule {
	private String RESERVED_DATE;
	private String RESERVED_HOUR;
	private String TATTOO_NAME;
	private String PAYMENT_SN;
	private String NAME;
	private String TEL;
	
	
	
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
	public String getRESERVED_DATE() {
		return RESERVED_DATE;
	}
	public void setRESERVED_DATE(String rESERVED_DATE) {
		RESERVED_DATE = rESERVED_DATE;
	}
	public String getRESERVED_HOUR() {
		return RESERVED_HOUR;
	}
	public void setRESERVED_HOUR(String rESERVED_HOUR) {
		RESERVED_HOUR = rESERVED_HOUR;
	}
	public String getTATTOO_NAME() {
		return TATTOO_NAME;
	}
	public void setTATTOO_NAME(String tATTOO_NAME) {
		TATTOO_NAME = tATTOO_NAME;
	}
	public String getPAYMENT_SN() {
		return PAYMENT_SN;
	}
	public void setPAYMENT_SN(String pAYMENT_SN) {
		PAYMENT_SN = pAYMENT_SN;
	}
	
	
}

package com.yena.shop.tattoo.model;

public class Tattoo {
	private int id;
	private String nm;
	private String goods;
	private String image;
	private int price;
	private String color;
	private int sale;
	private String sale_start_dt;
	private String sale_end_dt;
	private String content;
	private String reg_dtm;
	private String upd_dtm;
	private String del_yn;
	
	
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getSale_start_dt() {
		return sale_start_dt;
	}
	public void setSale_start_dt(String sale_start_dt) {
		this.sale_start_dt = sale_start_dt;
	}
	public String getSale_end_dt() {
		return sale_end_dt;
	}
	public void setSale_end_dt(String sale_end_dt) {
		this.sale_end_dt = sale_end_dt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
	
}

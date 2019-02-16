package com.yena.shop.tattoo.dao;

import java.util.List;

import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;

public interface PaymentDao {
	/**
	 * 구매 이력 등록
	 * @param payment
	 */
	public void insertPayment(Payment payment);
	
	/**
	 * 구매 이력 삭제
	 * @param payment_sn
	 */
	public void deletePayment(int payment_sn);
	
	/**
	 * 구매 이력 1개 조회
	 * @param 구매번호
	 * @return
	 */
	public Payment selectPayment(int payment_sn);
	
	/**
	 * 구매 이력 모두 조회
	 * @param page
	 * @return
	 */
	public List selectPaymentList(Page page);
	
	/**
	 * 구매 이력 건수 조회
	 * @param pageVo
	 * @return
	 */
	public int selectTotalPayment(Page pageVo);
	
	/**
	 * 구매 이력 정보 수정
	 * @param payment
	 */
	public void updatePaymentCmplYn(Payment payment);
	
	public void updatePaymentReservedDt(Payment payment);
}

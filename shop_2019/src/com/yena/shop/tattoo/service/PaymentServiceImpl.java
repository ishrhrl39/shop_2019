package com.yena.shop.tattoo.service;

import java.util.List;

import com.yena.shop.tattoo.dao.PaymentDao;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;

public class PaymentServiceImpl implements PaymentService {
	private PaymentDao paymentDao;

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	@Override
	public void insertPayment(Payment payment) {
		paymentDao.insertPayment(payment);
	}

	@Override
	public void deletePayment(int payment_sn) {
		paymentDao.deletePayment(payment_sn);
	}

	@Override
	public Payment selectPayment(int payment_sn) {
		return paymentDao.selectPayment(payment_sn);
	}

	@Override
	public List selectPaymentList(Page page) {
		return paymentDao.selectPaymentList(page);
	}
	
	/**
	 * 구매 이력 건수 조회
	 * @param pageVo
	 * @return
	 */
	public int selectTotalPayment(Page pageVo) {
		return paymentDao.selectTotalPayment(pageVo);
	}

	@Override
	public void updatePaymentCmplYn(Payment payment) {
		paymentDao.updatePaymentCmplYn(payment);
	}

	@Override
	public void updatePaymentReservedDt(Payment payment) {
		paymentDao.updatePaymentReservedDt(payment);
	}

	@Override
	public List selectBestPayment() {
		return paymentDao.selectBestPayment();
	}
}

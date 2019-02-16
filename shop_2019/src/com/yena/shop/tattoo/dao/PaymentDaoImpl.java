package com.yena.shop.tattoo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Payment;

public class PaymentDaoImpl extends SqlMapClientDaoSupport implements PaymentDao {
	@Autowired
	public PaymentDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapPayment.";

	@Override
	public void insertPayment(Payment payment) {
		getSqlMapClientTemplate().insert(namespace + "insertPayment", payment);
	}

	@Override
	public void deletePayment(int payment_sn) {
		getSqlMapClientTemplate().delete(namespace + "deletePayment", payment_sn);
	}

	@Override
	public Payment selectPayment(int payment_sn) {
		return (Payment) getSqlMapClientTemplate().queryForObject(namespace + "selectPayment", payment_sn);
	}

	@Override
	public List selectPaymentList(Page page) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectPaymentList", page);
	}
	
	@Override
	public int selectTotalPayment(Page pageVo) {
		return (int) getSqlMapClientTemplate().queryForObject(namespace + "selectTotalPayment", pageVo);
	}

	@Override
	public void updatePaymentCmplYn(Payment payment) {
		getSqlMapClientTemplate().update(namespace + "updatePaymentCmplYn", payment);
	}

	@Override
	public void updatePaymentReservedDt(Payment payment) {
		getSqlMapClientTemplate().update(namespace + "updatePaymentReservedDt", payment);
	}
}

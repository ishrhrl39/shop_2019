package com.yena.shop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.model.Faq;

public class FaqDaoImpl extends SqlMapClientDaoSupport implements FaqDao {
	
	@Autowired
	public FaqDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapFaq.";
		

	@Override
	public void insertFaq(Faq faq) {
		getSqlMapClientTemplate().insert(namespace + "insertFaq", faq);
	}

	@Override
	public void updateFaq(Faq faq) {
		getSqlMapClientTemplate().insert(namespace + "updateFaq", faq);
	}

	@Override
	public void deleteFaq(int no) {
		getSqlMapClientTemplate().insert(namespace + "deleteFaq", no);
	}

	@Override
	public Faq selectFaqOne(int no) {
		return (Faq) getSqlMapClientTemplate().queryForObject(namespace + "selectFaqOne", no);
	}

	@Override
	public List selectFaqList() {
		return getSqlMapClientTemplate().queryForList(namespace + "selectFaqList");
	}
}

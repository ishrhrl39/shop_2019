package com.yena.shop.tattoo.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yena.shop.tattoo.model.TattooSchedule;

public class ScheduleDaoImpl extends SqlMapClientDaoSupport implements ScheduleDao {
	@Autowired
	public ScheduleDaoImpl(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	private String namespace = "SqlMapSchedule.";

	@Override
	public void insertSchedule(TattooSchedule schedule) {
		getSqlMapClientTemplate().insert(namespace + "insertSchedule", schedule);
	}

	@Override
	public void deleteSchedule(TattooSchedule schedule) {
		getSqlMapClientTemplate().insert(namespace + "deleteSchedule", schedule);
	}

	@Override
	public List selectScheduleList(Map param) {
		return getSqlMapClientTemplate().queryForList(namespace + "selectScheduleList", param);
	}

	@Override
	public Object selectScheduleOne(TattooSchedule schedule) {
		return getSqlMapClientTemplate().queryForObject(namespace + "selectScheduleOne", schedule);
	}
}

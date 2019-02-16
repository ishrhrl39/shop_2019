package com.yena.shop.tattoo.service;

import java.util.List;
import java.util.Map;

import com.yena.shop.tattoo.dao.ScheduleDao;
import com.yena.shop.tattoo.model.TattooSchedule;

public class ScheduleServiceImpl implements ScheduleService {
	private ScheduleDao scheduleDao;

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public void insertSchedule(TattooSchedule schedule) {
		scheduleDao.insertSchedule(schedule);
	}

	@Override
	public void deleteSchedule(TattooSchedule schedule) {
		scheduleDao.deleteSchedule(schedule);
	}

	@Override
	public List selectScheduleList(Map param) {
		return scheduleDao.selectScheduleList(param);
	}

	@Override
	public Object selectScheduleOne(TattooSchedule schedule) {
		return scheduleDao.selectScheduleOne(schedule);
	}

	
}

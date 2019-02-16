package com.yena.shop.tattoo.dao;

import java.util.List;
import java.util.Map;

import com.yena.shop.model.User;
import com.yena.shop.model.WithDraw;
import com.yena.shop.model.WithDrawLog;
import com.yena.shop.tattoo.model.Page;
import com.yena.shop.tattoo.model.Tattoo;
import com.yena.shop.tattoo.model.TattooSchedule;

public interface ScheduleDao {
	// 타투이스트 스케줄 등록
	public void insertSchedule(TattooSchedule schedule);
	
	// 타투이스트 스케줄 삭제
	public void deleteSchedule(TattooSchedule schedule);
	
	// 타투이스트 스케줄 목록 조회
	public List selectScheduleList(Map param);
	
	// 타투이스트 스케줄 조회
	public Object selectScheduleOne(TattooSchedule schedule);
}

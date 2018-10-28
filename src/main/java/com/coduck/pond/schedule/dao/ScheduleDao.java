package com.coduck.pond.schedule.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.schedule.vo.ScheduleVo;

@Repository
public class ScheduleDao {
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "Mappers.ScheduleMapper.";
	
	public List<ScheduleVo> getDateInfo(int groupNum) {
		return session.selectList(NAMESPACE+"getDateInfo", groupNum);
	}
	
	public void addSchedule(ScheduleVo vo) {
		session.insert(NAMESPACE+"addSchedule", vo);
	}
	
	public List<ScheduleVo> getSchedule_month(Map<String, String> map){
		return session.selectList(NAMESPACE+"getSchedule_month", map);
	}
	
	public int updateSchedule(ScheduleVo vo) {
		return session.update(NAMESPACE+"updateSchedule", vo);
	}
	
	public int deleteSchedule(String scheduleNum) {
		return session.update(NAMESPACE+"deleteSchedule", scheduleNum);
	}
	
	public ScheduleVo getScheduleOne(int scheduleNum) {
		return session.selectOne(NAMESPACE+"getScheduleOne", scheduleNum);
	}
}

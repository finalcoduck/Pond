package com.coduck.pond.schedule.dao;

import java.util.List;

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
	
	public List<ScheduleVo> getSchedule_month(String yymm){
		return session.selectList(NAMESPACE+"getSchedule_month", yymm);
	}
}

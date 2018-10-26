package com.coduck.pond.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.schedule.dao.ScheduleDao;
import com.coduck.pond.schedule.vo.ScheduleVo;

@Service
public class ScheduleServiceImpl {
	@Autowired
	private ScheduleDao scheduleDao;
	
	public List<ScheduleVo> getDateInfo(int groupNum){
		return scheduleDao.getDateInfo(groupNum);
	}
	
	public void addSchedule(ScheduleVo vo) {
		scheduleDao.addSchedule(vo);
	}
	
	public List<ScheduleVo> getSchedule_month(String year, String month){
		if(month.length() == 1) {
			month = "0"+month;
		}
		System.out.println("month"+month);
		System.out.println("year"+year);
		String yymm = year + month;
		List<ScheduleVo> list = scheduleDao.getSchedule_month(yymm);
		return list;
	}
}

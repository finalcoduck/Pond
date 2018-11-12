package com.coduck.pond.schedule.service;

import java.util.HashMap;
import java.util.List;

import com.coduck.pond.schedule.vo.AttendedVo;
import com.coduck.pond.schedule.vo.SrchAttendedDto;

public interface AttendedService {
	
	public boolean isAttended(AttendedVo attendedVo);
	
	public List<AttendedVo> selectMonthAttended(SrchAttendedDto srchAttendedDto);
	
	public HashMap<String, Object> attendedIn(AttendedVo attendedVo);
	
}

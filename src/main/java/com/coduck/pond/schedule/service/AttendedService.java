package com.coduck.pond.schedule.service;

import java.util.HashMap;


import com.coduck.pond.schedule.vo.AttendedVo;

public interface AttendedService {
	
	public boolean isAttended(AttendedVo attendedVo);
	
	public HashMap<String, Object> attendedIn(AttendedVo attendedVo);
	
}

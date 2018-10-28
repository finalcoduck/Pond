package com.coduck.pond.schedule.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.schedule.service.ScheduleServiceImpl;

@Controller
public class ScheduleDeleteController {
	@Autowired
	private ScheduleServiceImpl scheduleService;
	
	@RequestMapping(value="/schedule/delete", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteSchedule(String scheduleNum, String scheduleStartDate) {
		String yymm = splitDate(scheduleStartDate);
		int n = scheduleService.deleteSchedule(scheduleNum);
		Map<String, String> map = new HashMap<>();
		map.put("year", yymm.substring(0, 2));
		map.put("month", yymm.substring(2, 4));
		if(n>0) {
			map.put("msg", "true");
		}else {
			map.put("msg", "false");
		}
		
		return map;
	}
	
	public String splitDate(String scheduleStartDate) {
		String[] newDate = scheduleStartDate.split("-");
		String year = newDate[0].substring(0, 2);
		String month = newDate[1];
		String resultString = year + month;
		return resultString;
	}
}

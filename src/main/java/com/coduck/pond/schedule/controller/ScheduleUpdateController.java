package com.coduck.pond.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.coduck.pond.schedule.service.ScheduleServiceImpl;
import com.coduck.pond.schedule.vo.ScheduleVo;

@Controller
public class ScheduleUpdateController {
	@Autowired
	private ScheduleServiceImpl scheduleService;
	
	@RequestMapping(value="/schedule/updatepage", method=RequestMethod.GET)
	public String goUpdatePage(Model model, int num, String start, String end) {
		ScheduleVo scheduleVo = scheduleService.getScheduleOne(num);
		model.addAttribute("vo", scheduleVo);
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		return "/group/scheduleUpdate";
	}
	
	@RequestMapping(value="/schedule/updatepage", method=RequestMethod.POST)
	public String goUpdatePage(Model model, ScheduleVo vo) {
		int n = scheduleService.updateSchedule(vo);
		return "forward:/schedule/info";
	}
}

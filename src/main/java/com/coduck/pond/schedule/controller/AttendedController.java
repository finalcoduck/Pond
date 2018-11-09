package com.coduck.pond.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coduck.pond.schedule.service.AttendedService;



@Controller
public class AttendedController {
	
	@Autowired
	private AttendedService attendedService;
	
	@RequestMapping(value="/group/attended")
	public String attendedPage() {
		
		
		
		return "/group/attended";
	}
	
}

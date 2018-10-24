package com.coduck.pond.member.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/erd", method = RequestMethod.GET)
	public String home() { //zz
		System.out.println("!");
		return "/erd";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() { //zz
		return "/test";
	}	
	
	@RequestMapping(value = "group/erd", method = RequestMethod.GET)
	public String home1() { //zz
		System.out.println("!");
		return "/erd1";
	}
}

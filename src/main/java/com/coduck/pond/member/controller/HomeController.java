package com.coduck.pond.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) { //zz
		return "home";
	}
	
	@RequestMapping(value = "/group/test", method = RequestMethod.GET)
	public String test(Model model) { //zz
		return "/group/test";
	}	
}

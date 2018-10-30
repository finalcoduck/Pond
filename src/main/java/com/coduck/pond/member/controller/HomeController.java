package com.coduck.pond.member.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.argumentResolver.HeaderInfo;

@Controller
public class HomeController {
	/*@RequestMapping(value = "/erd", method = RequestMethod.GET)
	public String home(HeaderInfo headerInfo) { //zz

		System.out.println("-----------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------------------------");
		return "/";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() { //zz
		return "/main/join/member";
	}	
	
	@RequestMapping(value = "group/erd", method = RequestMethod.GET)
	public String home1() { //zz
		System.out.println("!");
		return "/erd1";
	}*/
}

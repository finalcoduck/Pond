package com.coduck.pond.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberMoveController {
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) { 
		return "home";
	}*/
	
	@RequestMapping(value = "/member/main/home", method = RequestMethod.GET)
	public String go(Model model) { 
		return "home";
	}
	
	@RequestMapping("/member/main/join")
	public String joinPage() {
		return "join";
	}
	
	@RequestMapping("/member/main/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/member/main/findPwd")
	public String findPwd() {
		return "findPwd";
	}
	
}

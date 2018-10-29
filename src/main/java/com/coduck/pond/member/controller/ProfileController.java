package com.coduck.pond.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemVo;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping("/member/profile")
	public String goProfile(MemVo memVo, Model model) {
		return "/member/profile";
	}
}

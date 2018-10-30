package com.coduck.pond.group.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.argumentResolver.HeaderInfo;

@Controller
public class GroupController {
	
	
	@RequestMapping(value = "/group/group-main", method = RequestMethod.GET)
	public String groupMain() { 
		return "/group/group-main";
	}

}

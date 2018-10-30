package com.coduck.pond.selectgroup.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.argumentResolver.HeaderInfo;

@Controller
public class SelectGroupController {
	
	
	@RequestMapping(value = "/selectgroup/index", method = RequestMethod.GET)
	public String selectGroupMain() { 
		return "/selectgroup/index";
	}
	
	@RequestMapping(value = "/selectgroup/insert-group", method = RequestMethod.GET)
	public String insertGroup() { 
		return "/selectgroup/insert-group";
	}

}

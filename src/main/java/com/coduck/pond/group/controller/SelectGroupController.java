package com.coduck.pond.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.argumentResolver.HeaderInfo;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class SelectGroupController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value = "/selectgroup/index", method = RequestMethod.GET)
	public String selectGroupMain(MemDto memDto, Model model) { 
		System.out.println(memDto.getMemVo().getMemEmail());
		
		
		List<GroupVo> groupList =  groupService.selectGroupList(memDto.getMemVo().getMemEmail());
		
		model.addAttribute("groupList", groupList);
		
		
		
		return "/selectgroup/index";
	}
	
	@RequestMapping(value = "/selectgroup/insert-group", method = RequestMethod.GET)
	public String insertGroup() { 
		return "/selectgroup/insert-group";
	}

}

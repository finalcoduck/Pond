package com.coduck.pond.group.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.core.utils.GetMemDtoUtility;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupMemNumDto;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class SelectGroupController {
	
	@Autowired
	GroupService groupService;
	@Autowired
	ProfileService profileService;
	
	@RequestMapping(value = "/selectgroup/index", method = {RequestMethod.GET,RequestMethod.POST})
	public String selectGroupMain(MemDto memDto, Model model, HttpSession session) {
		
		/*List<GroupVo> groupList =  groupService.selectGroupList(memDto.getMemVo().getMemEmail());*/
		List<GroupMemNumDto> groupMemNumList = groupService.getGroupMemNum(memDto.getMemVo().getMemEmail());
		model.addAttribute("groupList", groupMemNumList);
		
		return "/selectgroup/index";
	}
	
	@RequestMapping(value = "/selectgroup/insert-group", method = RequestMethod.GET)
	public String insertGroup(MemDto memDto) {
		return "/selectgroup/insert-group";
	}
	
	
	@RequestMapping(value = "/selectgroup/make-group-proc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> makeGroup(String groupName, String imgUrl, String memEmail, MemDto memDto, HttpSession session) {
		GroupVo groupVo = new GroupVo(0, groupName, null, 0, memEmail, null,null, '0', imgUrl, null);
		groupService.insertGorupDefault(groupVo);
		Map<String, String> map = new HashMap<>();
		map.put("msg", "success");
		//세션 업데이트
		Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memDto.getMemVo().getMemEmail());
		MemDto newMemDto = GetMemDtoUtility.getMemDto(memDto.getMemVo(), memGroupMap);
		session.setAttribute(CommonConstant.USER_SESSION_KEY, newMemDto);
		return map;
	} 
}

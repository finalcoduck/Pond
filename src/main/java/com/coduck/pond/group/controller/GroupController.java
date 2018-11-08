
package com.coduck.pond.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.board.service.SubjectService;
import com.coduck.pond.board.vo.SubjectVo;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping(value = "/group/group-main", method = {RequestMethod.GET,RequestMethod.POST})
	public String groupMain(int groupNum, MemDto memDto, Model model) {
		
		//로그인 한 아이디가 해당 그룹에 유효한지 체크
		if(!memDto.getMemGroupMap().containsKey(groupNum)) {
			return "forward:/selectgroup/index";
		}			
		
		//넘겨 주어야할 정보 과제글, 공지글 , 주제 
		List<SubjectVo> subjecList = subjectService.selectSubjectList(groupNum);
		GroupVo groupVo = groupService.selectGroup(groupNum);
		
		
		model.addAttribute("subjectList", subjecList);
		model.addAttribute("groupVo", groupVo);
		
		return "/group/group-main";
	}
	
	@RequestMapping(value="/group/setting-subject")
	public String settingGroupSubject(int groupNum, MemDto memDto, Model model) {
		
		List<SubjectVo> subjectList = subjectService.selectSubjectList(groupNum);
		GroupVo groupVo = groupService.selectGroup(groupNum);
		
		model.addAttribute("subjectList",subjectList);
		model.addAttribute("groupVo", groupVo);
		return "/group/setting-subject";
	}	
	
}
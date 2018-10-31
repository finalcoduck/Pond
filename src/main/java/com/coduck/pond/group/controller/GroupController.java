package com.coduck.pond.group.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class GroupController {
	
	@Autowired
	GroupService groupService;
	
	@RequestMapping(value = "/group/group-main", method = RequestMethod.GET)
	public String groupMain(int groupNum, MemDto memDto) {
		//넘겨 주어야할 정보 과제글, 공지글 , 주제 
		
		
		//로그인 한 아이디가 해당 그룹에 유효한지 체크
		if(!memDto.getMemGroupMap().containsKey(groupNum)) {
			return "forward:/select/index";
		}		
		
		//그룹내 지위 에따른 다른 뷰 출력
		
		
		
		System.out.println(groupNum);
		
		
		return "/group/group-main";
	}

}

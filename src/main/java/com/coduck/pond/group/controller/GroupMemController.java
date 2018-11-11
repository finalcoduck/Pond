package com.coduck.pond.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.coduck.pond.member.service.MemberManageService;
import com.coduck.pond.member.vo.KickHistory;

@Controller
public class GroupMemController {
	@Autowired
	private MemberManageService manageService;
	
	@RequestMapping("/group/member-kick")
	public String kickMem(int groupNum, String memEmail) {
		System.out.println(groupNum+"///"+memEmail);
		//그룹디비에서 디비 삭제
		manageService.kickMemFromGroup(groupNum, memEmail);
		//강퇴 히스토리 작성
		KickHistory kickHistory = new KickHistory();
		kickHistory.setGroupNum(groupNum);
		kickHistory.setMemEmail(memEmail);
		manageService.kickHistoryInsert(kickHistory);
		
		return "forward:/group/member";
	}
	
}

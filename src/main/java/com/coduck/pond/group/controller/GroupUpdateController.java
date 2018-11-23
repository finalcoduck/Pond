package com.coduck.pond.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coduck.pond.group.service.GroupUpdateService;

@Controller
public class GroupUpdateController {
	@Autowired
	private GroupUpdateService groupUpdateService;
	
	/*
	 *  그룹정보에서 수정할 컬럼값, 변경내용 받아서 처리
	 */
	@RequestMapping("/group/update/group-info")
	public String groupUpdate(String groupNum, String column, String columnValue) {
		try {
			groupUpdateService.updateGroupColumn(column, columnValue, groupNum);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "forward:/group/detail/setting";
	}
}

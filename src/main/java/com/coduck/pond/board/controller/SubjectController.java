package com.coduck.pond.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.board.service.SubjectService;
import com.coduck.pond.board.vo.SubjectVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@RequestMapping(value = "/board/insert/subject", method = RequestMethod.POST)
	public String insertSubject(SubjectVo subjectVo,MemDto memDto) {
		
		//해당 그룹의 선생님,그룹생성자 인지 확인
/*		if(memDto.getMemGroupMap().get(subjectVo.getGroupNum()) == 'T') {
			
		}*/
		
		//추가
		//중복처리 해야함
		subjectService.insertSubject(subjectVo);
		
		
		
		return "forward:/group/group-main";
	}
	
	
}

package com.coduck.pond.curriculum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coduck.pond.curriculum.service.CurriculumSerivce;
import com.coduck.pond.curriculum.vo.CurriculumVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class CurriculumController {
	@Autowired
	private CurriculumSerivce curriculumService;
	
	@RequestMapping("/group/curriculum")
	public String defaultCRC(@RequestParam(value="groupNum")int groupNum, Model model, MemDto memDto) {
		char status = memDto.getMemGroupMap().get(groupNum);
		List<CurriculumVo> list = curriculumService.getAllCurriculum(groupNum);
		model.addAttribute("list", list);
		model.addAttribute("groupNum", groupNum);
		model.addAttribute("status", status);
		return "/group/curriculum";
	}
	
	@RequestMapping("/group/addPage")
	public String addPage(int groupNum, Model model) {
		model.addAttribute("groupNum", groupNum);
		return "/group/add-curriculum";
	}
	
	@RequestMapping(value="/group/crc-insert", method=RequestMethod.POST)
	public String insertCurriculum(CurriculumVo vo) {
		curriculumService.insertCurriculum(vo);
		return "forward:/group/curriculum";
	}
	
	@RequestMapping(value="/group/crc-update-page", method=RequestMethod.GET)
	public String updatePage(int crcNum, Model model) {
		CurriculumVo vo = curriculumService.getOneCurriculum(crcNum);
		model.addAttribute("vo", vo);
		
		return "/group/update-curriculum";
	}
	
	@RequestMapping(value="/group/crc-update", method=RequestMethod.POST)
	public String updatePage(CurriculumVo vo) {
		curriculumService.updateCurriculum(vo);
		
		return "forward:/group/curriculum";
	}
	
	@RequestMapping(value="/group/crc-delete", method=RequestMethod.GET)
	public String deleteCurriculum(int crcNum) {
		curriculumService.deleteCurriculum(crcNum);
		
		return "forward:/group/curriculum";
	}
}

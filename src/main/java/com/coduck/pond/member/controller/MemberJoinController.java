package com.coduck.pond.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.member.service.MemberJoinService;
import com.coduck.pond.member.vo.MemVo;
import com.coduck.pond.member.vo.PreMemVo;

@Controller
public class MemberJoinController {
	@Autowired
	private MemberJoinService memberJoinService;
	
	/*
	 * 	메일 인증전 pre_mem 테이블에 담기
	 */
	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public String join(PreMemVo vo, Model model) {
		try {
			MemVo memVo = memberJoinService.checkDupli(vo.getPreEmail());
			if(memVo != null) {
				model.addAttribute("msg","이미 존재하는 아이디입니다.");
				return "forward:/";
			}
			memberJoinService.insertPreMember(vo);
		}catch (Exception e) {
			return "error";
		}
		return "/email-confirm";
	}
	
	/*
	 * 메일 인증 확인
	 * pre_mem --> mem 테이블로 이동 후 pre_mem 정보삭제
	 */
	@RequestMapping(value="/join/emailConfirm", method=RequestMethod.GET)
	public String emailConfirm(String key, String email, Model model) {
		try {
			int n = memberJoinService.insertMember(key, email);
			return "/main/email-confirm-ok";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/";
		}
	}
}

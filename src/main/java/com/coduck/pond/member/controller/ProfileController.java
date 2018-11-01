package com.coduck.pond.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * (key:그룹번호 , value:그룹정보객체) HashMap 사용
	 */
	@RequestMapping("/member/profile")
	public String goProfile(Model model, HttpSession session) {
		MemDto memDto = (MemDto)session.getAttribute("memDto");
		System.out.println(memDto);
		Set<Integer> keySet = memDto.getKeySet();
		Map<Integer, GroupVo> groupMap = new HashMap<>();
		groupMap = profileService.getGroupInfo(keySet);
		model.addAttribute("groupMap", groupMap);
		System.out.println(memDto.getMemVo().getMemEmail()+"@@@@@@@@@@@@@");
		model.addAttribute(CommonConstant.USER_SESSION_KEY, memDto);
		return "/member/profile";
	}
	
	/*
	 *  Ajax를 통한 핸드폰 번호 수정
	 */
	@RequestMapping("/member/update-phone/proc")
	@ResponseBody
	public Map<String, String> updatePhone(String phone, String email) {
		Map<String, String> map = new HashMap<>();
		profileService.updatePhone(phone, email);
		return map;
	}
	
	/*
	 *  Ajax를 통한 비밀번호 수정
	 */
	@RequestMapping("/member/update-pwd/proc")
	@ResponseBody
	public Map<String, String> updatePwd(String newPwd, String email) {
		String memPwd = passwordEncoder.encode(newPwd);
		profileService.updatePwd(email, memPwd);
		Map<String, String> map = new HashMap<>();
		return map;
	}
	
	/*
	 *  Ajax를 통한 현재 비밀번호 확인
	 */
	@RequestMapping("/member/confirm-pwd/proc")
	@ResponseBody
	public Map<String, String> confrimPwd(String nowPwd, String email, String nowEncPwd) {
		String memPwd = passwordEncoder.encode(nowPwd);
		Map<String, String> map = new HashMap<>();
		if(passwordEncoder.matches(nowPwd, nowEncPwd)) {
			map.put("pwdConfirmMsg", "true");
		}else {
			map.put("pwdConfirmMsg", "false");
		}
		return map;
	}
}

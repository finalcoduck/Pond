package com.coduck.pond.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.core.utils.mail.MailService;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupMemVo;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.service.InviteSerivce;
import com.coduck.pond.member.service.MemberManageService;
import com.coduck.pond.member.vo.KickHistory;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class InviteController {
	@Autowired
	private InviteSerivce inviteSerivce;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private GroupService groupService;
	@Autowired
	private MemberManageService managerSerivce;
	
	/*
	 *  초대코드 메일 보내기 컨트롤러
	 */
	@RequestMapping("/group/invite/proc")
	@ResponseBody
	public Map<String, String> invitePeople(String mails, String inviteCode, Model model, String groupName) {
		String[] mailArr = mails.split(",");
		System.out.println(mailArr);
		MailService mailSerivce = new MailService();
		Map<String, String> map = new HashMap<>();
		
		try {
			for (int i = 0; i < mailArr.length; i++) {
				mailSerivce.drawSendInviteCode(mailSender, inviteCode, mailArr[i], groupName);
			}
			map.put("msg", "success");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}
	
	/*
	 *  초대코드 입력 컨트롤러
	 */
	@RequestMapping("/group/invite/input")
	public String invitedMem(Model model, MemDto memDto, String inviteCode) {
		System.out.println("@@@@@@@@@"+inviteCode);
		inviteCode = inviteCode.trim();
		Map<String, Object> map = inviteSerivce.findGroupNum(inviteCode);
		GroupVo groupVo = (GroupVo)map.get("groupVo");
		if(groupVo==null) {
			model.addAttribute("msg", "유효한 코드가 아닙니다.");
			return "forward:/selectgroup/index";
		}
		//강퇴당한 회원 여부 체크
		KickHistory kh = managerSerivce.checkKickedMem(groupVo.getGroupNum(), memDto.getMemVo().getMemEmail());
		if(kh != null) {
			model.addAttribute("msg", "이미 차단된 회원이라 가입이 불가합니다.");
			return "forward:/selectgroup/index";
		}
		
		GroupMemVo groupMemVo = groupService.dupliInviteCode(memDto.getMemVo().getMemEmail(), String.valueOf(groupVo.getGroupNum()));
		if(groupMemVo != null) {
			model.addAttribute("msg","이미 가입한 회원 입니다.");
			return "forward:/selectgroup/index"; 
		}
		
		groupMemVo = new GroupMemVo(0, groupVo.getGroupNum(), memDto.getMemVo().getMemEmail(), (Character)map.get("status"));
		try {
			inviteSerivce.insertGroupMem(groupMemVo);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "forward:/selectgroup/index";
	}
}

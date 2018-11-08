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
import com.coduck.pond.member.vo.MemDto;

@Controller
public class InviteController {
	@Autowired
	private InviteSerivce inviteSerivce;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private GroupService groupSerivce;
	//그룹번호 그룹 초대 코드 두개 
	@RequestMapping("/group/member")
	public String goGroupMember(int groupNum, Model model) {
		GroupVo groupVo = groupSerivce.selectGroup(groupNum);
		model.addAttribute("groupVo", groupVo);
		return "/group/group-member";
	}
	
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
	
	@RequestMapping("/asd")
	@ResponseBody //inviteCode 학생 / 선생 처리 해주어야함
	public String invitedMem(Model model, MemDto memDto, String inviteCode) {
		inviteCode = inviteCode.trim();
		char status = inviteCode.charAt(inviteCode.length()-1);
		if(status == '@') {
			status = 'M';
		}else {
			status = 'S';
		}
		GroupVo groupVo = inviteSerivce.findGroupNum(inviteCode);
		GroupMemVo groupMemVo = new GroupMemVo(0, groupVo.getGroupNum(), memDto.getMemVo().getMemEmail(), status);
		try {
			inviteSerivce.insertGroupMem(groupMemVo);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}

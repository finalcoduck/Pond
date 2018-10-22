package com.coduck.pond.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.coduck.pond.core.utils.mail.MailService;
import com.coduck.pond.core.utils.mail.TempKey;
import com.coduck.pond.member.dao.MemberJoinDao;
import com.coduck.pond.member.dao.MemberLoginDao;
import com.coduck.pond.member.vo.MemAuthVo;
import com.coduck.pond.member.vo.MemVo;

@Service
public class MemberLoginServiceImpl {
	@Autowired
	private MemberLoginDao memberLoginDao;
	@Autowired
	private MemberJoinDao memberJoinDao;
	@Autowired
	private JavaMailSender mailSender;

	public MemVo getOneMem(String email) { // 이메일을 통한 멤버 정보 획득
		return memberLoginDao.getOneMem(email);
	}
	
	public MemVo getNaverMem(String id) { // 이메일을 통한 멤버 정보 획득
		return memberLoginDao.getNaverMem(id);
	}
	
	public MemVo checkMem(String memEmail, String memPwd) { // 이메일을 통한 멤버 정보 획득
		Map<String, String> map = new HashMap<>();
		map.put("email", memEmail);
		map.put("pwd", memPwd);
		return memberLoginDao.checkMem(map);
	}
	
	public void updatePhone(String memEmail, String memPhone) {
		Map<String, String> map = new HashMap<>();
		map.put("email", memEmail);
		map.put("phone", memPhone);
		memberLoginDao.updatePhone(map);
	}
	
	public void changeNewPwd(String memEmail, String newPwd) {
		Map<String, String> map = new HashMap<>();
		map.put("email", memEmail);
		map.put("pwd", newPwd);
		memberLoginDao.changeNewPwd(map);
	}
	
	public void mailTofindPwd(String memEmail) {
		String authKey = new TempKey().getKey(50, false);
		MemAuthVo memAuthVo = new MemAuthVo(authKey, memEmail);
		
		try {
			memberJoinDao.insertAuthKey(memAuthVo);
		
			MailService mailService = new MailService();
			mailService.drawSendMailToPwd(mailSender, authKey, memEmail); //여까지
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * 새로운 비밀번호 설정시 인증키 확인
	 */
	public int authConfirm(String key, String email) {
		Map<String, String> map = new HashMap<>();
		map.put("authKey", key);
		map.put("email", email);
		return memberLoginDao.authConfirm(map);
	}
}

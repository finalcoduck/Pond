package com.coduck.pond.member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coduck.pond.core.utils.mail.MailService;
import com.coduck.pond.core.utils.mail.TempKey;
import com.coduck.pond.member.dao.MemberJoinDao;
import com.coduck.pond.member.vo.MemAuthVo;
import com.coduck.pond.member.vo.PreMemVo;

@Service
public class MemberJoinServiceImpl implements MemberJoinService{
	@Autowired
	private MemberJoinDao memberJoinDao;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// @@@@@@@@@@@@@ 트랜젝션 처리 해줘야함 
	public void insertPreMember(PreMemVo preMemVo) {
		String encPwd = passwordEncoder.encode(preMemVo.getPrePassword()); //비밀번호 암호화
		preMemVo.setPrePassword(encPwd);
		// 최초 가입시 정보 인서트
		memberJoinDao.insertPreMember(preMemVo);
		// 메일인증을 위한 인증값 
		String authKey = new TempKey().getKey(50, false);
		MemAuthVo memAuthVo = new MemAuthVo(authKey, preMemVo.getPreEmail());
		memberJoinDao.insertAuthKey(memAuthVo);
		
		MailService mailService = new MailService();
		try {
			mailService.drawSendMail(mailSender, authKey, preMemVo.getPreEmail());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int insertMember(String authKey, String email) { 
		PreMemVo preMemVo = memberJoinDao.getPreMem(email);
		System.out.println(preMemVo);
		MemAuthVo memAuthVo = new MemAuthVo(authKey, email); 
		int n = memberJoinDao.deletePreMem(memAuthVo); // 인증키와 이메일 존재시 삭제
		memberJoinDao.deleteAuthKey(email);
		if(n > 0) {
			memberJoinDao.insertMember(preMemVo); // 인증 후 preMem --> Mem 이동
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public void naverToInsertMember(Map<String, String> map) {
		memberJoinDao.naverToInsertMember(map);
	}
}












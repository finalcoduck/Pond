package com.coduck.pond.core.utils.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

	public void drawSendMail(JavaMailSender mailSender,String authKey, String email) throws MessagingException, UnsupportedEncodingException {
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[메일인증]");
		sendMail.setText(new StringBuffer().append("<h1>인증해주세여</h1>")
		.append("<a href='http://localhost:8090/pond/join/emailConfirm?key=")
		.append(authKey)
		.append("&email=")
		.append(email)
		.append("' target='_blank'>인증하기</a>")
		.toString());
		sendMail.setFrom("soulstrk1234@gmail.com", "운영진");
		sendMail.setTo(email);
		sendMail.send();
	}
	
	public void drawSendMailToPwd(JavaMailSender mailSender,String authKey, String email) throws MessagingException, UnsupportedEncodingException {
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[메일인증]");
		sendMail.setText(new StringBuffer().append("<h1>인증해주세여</h1>")
		.append("<a href='http://localhost:8090/pond/member/login/emailConfirmNewPwd?key=")
		.append(authKey)
		.append("&email=")
		.append(email)
		.append("' target='_blank'>인증하기</a>")
		.toString());
		sendMail.setFrom("soulstrk1234@gmail.com", "운영진");
		sendMail.setTo(email);
		sendMail.send();
	}
	
	public void drawSendInviteCode(JavaMailSender mailSender,String inviteCode, String email, String groupName) throws MessagingException, UnsupportedEncodingException {
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[Pond 그룹 초대코드]");
		sendMail.setText(new StringBuffer().append("<h1>'Pond'"+groupName+"에서 초대 코드가 도착했습니다.</h1>")
		.append("<h2 style='color: red;'>초대코드</h2>")
		.append("<span style='color: blue;'>"+inviteCode+"</span>")
		.toString());
		sendMail.setFrom("soulstrk1234@gmail.com", "운영진");
		sendMail.setTo(email);
		sendMail.send();
	}
}

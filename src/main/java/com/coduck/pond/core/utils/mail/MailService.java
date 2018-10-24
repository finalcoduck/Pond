package com.coduck.pond.core.utils.mail;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

	public void drawSendMail(JavaMailSender mailSender,String authKey, String email) throws MessagingException, UnsupportedEncodingException {
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[메일인증]");
		sendMail.setText(new StringBuffer().append("<h1>인증해주세여</h1>")
		.append("<a href='http://localhost:8090/pond/member/main/join/emailConfirm?key=")
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
		.append("<a href='http://localhost:8090/pond/member/main/login/emailConfirmNewPwd?key=")
		.append(authKey)
		.append("&email=")
		.append(email)
		.append("' target='_blank'>인증하기</a>")
		.toString());
		sendMail.setFrom("soulstrk1234@gmail.com", "운영진");
		sendMail.setTo(email);
		sendMail.send();
	}
}

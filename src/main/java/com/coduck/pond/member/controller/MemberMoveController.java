package com.coduck.pond.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.member.vo.MemDto;

@Controller
public class MemberMoveController {
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOauth2Parameters;
	
	private OAuth2Operations oauthOperations;
	
	/*
	 *  최초 실행시 구글 URL정보 들고 이동
	 *  mainPage에서 구글 소셜로그인 버튼에 URL등록을 위해 
	 */
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home(Model model, HttpServletResponse response, String dpMsg, String loginFail, MemDto memDto) {
		if(memDto != null) {
			return "forward:/selectgroup/index";
		}
		oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOauth2Parameters);
		System.out.println("/googleLogin, url" + url);
		model.addAttribute("google_url", url);
		model.addAttribute("dpMsg", dpMsg);
		model.addAttribute("loginFail", loginFail);
		return "/main-body";
	}
/*	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public String home() {
		return "test";
	}*/
	
	/*@RequestMapping(value = "/member/main/home", method = RequestMethod.GET)
	public String go(Model model) { 
		return "home";
	}*/
	
	@RequestMapping("/join")
	public String joinPage() {
		return "/join-member";
	}
	
	@RequestMapping("/emailConfirm")
	public String emailConfirm() {
		return "/email-confirm";
	}
	
	@RequestMapping("/login/sendMail")
	public String setNewPwd() {
		return "/find-password";
	}
	
	/*@RequestMapping("/member/main/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/member/main/findPwd")
	public String findPwd() {
		return "findPwd";
	}*/
	
	
}

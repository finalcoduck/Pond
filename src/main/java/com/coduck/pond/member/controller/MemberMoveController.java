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

@Controller
public class MemberMoveController {
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOauth2Parameters;
	
	private OAuth2Operations oauthOperations;
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response) {
		
		 * 최초 실행할때 구글 url 정보들고 view로 이동
		 
		oauthOperations = googleConnectionFactory.getOAuthOperations();
		String url = oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOauth2Parameters);
		System.out.println("/googleLogin, url" + url);
		model.addAttribute("google_url", url);
		return "join";
	}*/
	
	@RequestMapping(value = "/member/main/home", method = RequestMethod.GET)
	public String go(Model model) { 
		return "home";
	}
	
	@RequestMapping("/member/main/join")
	public String joinPage() {
		return "join";
	}
	
	@RequestMapping("/member/main/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/member/main/findPwd")
	public String findPwd() {
		return "findPwd";
	}
	
}

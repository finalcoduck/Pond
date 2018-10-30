package com.coduck.pond.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.utils.GetMemDtoUtility;
import com.coduck.pond.member.service.MemberLoginServiceImpl;
import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;
import com.coduck.pond.member.vo.MemVo;

@Controller
public class GoogleController {
	@Autowired
    private GoogleConnectionFactory googleConnectionFactory;
    @Autowired
    private OAuth2Parameters googleOAuth2Parameters;
    private OAuth2Operations oauthOperations;
    @Autowired
    private MemberLoginServiceImpl memberLoginService;
    @Autowired
    private ProfileService profileService;
	/*
	 * 	구글 소셜 로그인시 DB저장 및 세션 처리
	 */
	@RequestMapping(value = "/login/googlecallback", method = {RequestMethod.GET, RequestMethod.POST})
	public String googleLoginSet(Model model, HttpServletRequest request, HttpSession session) {
		String code = request.getParameter("code");
		
		oauthOperations = googleConnectionFactory.getOAuthOperations();
        AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null);
        
        String accessToken = accessGrant.getAccessToken();
        Long expireTime = accessGrant.getExpireTime();
        
        if(expireTime != null && expireTime < System.currentTimeMillis()) {
        	accessToken = accessGrant.getRefreshToken();
        }
        
        Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
        Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
        
        PlusOperations plusOperations = google.plusOperations();
        Person profile = plusOperations.getGoogleProfile();
        System.out.println("User Uid : " + profile.getId());
        System.out.println("User Name : " + profile.getDisplayName());
        System.out.println("User Email : " + profile.getAccountEmail());
        System.out.println("User Profile : " + profile.getImageUrl());
        
        //구글 아이디 디비 저장
        MemVo memVo = memberLoginService.getGoogleMem(profile.getId());
        if(memVo == null) {
	        Map<String, String> map = new HashMap<>();
	        map.put("id", profile.getId());
	        map.put("name", profile.getDisplayName());
	        map.put("profilePic", profile.getImageUrl());
	        memberLoginService.googleToInsertMember(map);
	        memVo = memberLoginService.getGoogleMem(profile.getId());
	        Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memVo.getMemEmail());
			MemDto memDto = GetMemDtoUtility.getMemDto(memVo, memGroupMap);
			session.setAttribute("memDto", memDto);
	        return "/social-login-information";
        }else {
        	Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memVo.getMemEmail());
			MemDto memDto = GetMemDtoUtility.getMemDto(memVo, memGroupMap);
			session.setAttribute("memDto", memDto);
        	return "/test";
        }
	}
}

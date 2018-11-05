package com.coduck.pond.member.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.core.utils.GetMemDtoUtility;
import com.coduck.pond.member.service.MemberJoinService;
import com.coduck.pond.member.service.MemberLoginServiceImpl;
import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;
import com.coduck.pond.member.vo.MemVo;

@Controller
public class MemberLoginController {
	@Autowired
	private MemberJoinService memberJoinService;
	@Autowired
	private MemberLoginServiceImpl memberLoginService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping("/login/navercallback")
	// 네이버 로그인 연동후 사용자 정보 요청후 디비 작업
	public String naverCallback(String code, String state, Model model, HttpSession session, RedirectAttributes ra) {
		String clientId = "cXnG4ZMsAU0UT9_rvvIe";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "lwPvvFgpsq";//애플리케이션 클라이언트 시크릿값";
		try {
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&;";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		String refresh_token = "";
		System.out.println("apiURL="+apiURL);
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode="+responseCode);
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
				String inputLine;
				StringBuffer res = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if(responseCode==200) {
				res.toString();
				JSONParser jsonParser = new JSONParser();
				JSONObject obj = (JSONObject)jsonParser.parse(res.toString());
				access_token = (String)obj.get("access_token");
				refresh_token = (String)obj.get("refresh_token");
			}
			String header = "Bearer "+access_token;
			
			apiURL = "https://openapi.naver.com/v1/nid/me";
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			responseCode = con.getResponseCode();
			if(responseCode==200) { // 정상 호출
			     br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
				String inputLine1;
				StringBuffer response = new StringBuffer();
			while ((inputLine1 = br.readLine()) != null) {
				response.append(inputLine1);
			}
				br.close();
				//////////////네이버 회원 정보 디비에 넣기 ////////////////
				JSONParser parser = new JSONParser();
				System.out.println(response.toString());
				JSONObject obj = (JSONObject)parser.parse(response.toString());
				JSONObject obj1 = (JSONObject)obj.get("response");
				String email = (String)obj1.get("email");
				
				// 소셜 로그인 연동 메일이 이미 등록된 메일일 경우
				MemVo memVo = memberLoginService.getOneMem(email);
				if(memVo != null) {
					ra.addAttribute("dpMsg","이미 가입된 이메일 입니다");
					return "redirect:/";
				}
				String name = (String)obj1.get("name");
				String id = (String)obj1.get("id");
				
				// 소셜 로그인 연동을 이미 한번 했을 경우
				memVo = memberLoginService.getNaverMem(id);
				if(memVo != null) {
					Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memVo.getMemEmail());
					MemDto memDto = GetMemDtoUtility.getMemDto(memVo, memGroupMap);
					session.setAttribute(CommonConstant.USER_SESSION_KEY, memDto);
					return "forward:/selectgroup/index";
				}
				String profilePic = (String)obj1.get("profile_image");
				HashMap<String, String> map = new HashMap<>();
				map.put("email", email);
				map.put("name", name);
				map.put("id", id);
				map.put("profilePic", profilePic);
				memberJoinService.naverToInsertMember(map);
				memVo = memberLoginService.getNaverMem(id);
				Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memVo.getMemEmail());
				MemDto memDto = GetMemDtoUtility.getMemDto(memVo, memGroupMap);
				session.setAttribute(CommonConstant.USER_SESSION_KEY, memDto);
				////////////// 네이버 회원 정보 디비에 넣기 ////////////////
				return "/social-login-information";
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return "redirect:/";
			}
	}
	
	// 일반회원 로그인 컨트롤러
	@RequestMapping(value="/login/normal", method=RequestMethod.POST)
	public String normalLogin(String memEmail, String memPwd, Model model, HttpSession session, RedirectAttributes ra) {
		MemVo memVo = null;
		try {
			memVo = memberLoginService.getOneMem(memEmail); // 존재하는 이메일 인지 확인
			if(passwordEncoder.matches(memPwd, memVo.getMemPwd())) { //입력받은 패스워드를 암호화시켜 비교후 같으면 true
				System.out.println(memVo.getMemEmail());
				Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memVo.getMemEmail());
				MemDto memDto = GetMemDtoUtility.getMemDto(memVo, memGroupMap);
				session.setAttribute(CommonConstant.USER_SESSION_KEY, memDto);
				return "forward:/selectgroup/index";
			}else {
				ra.addAttribute("loginFail","이메일 혹은 비밀번호를 확인해주세요");
				return "redirect:/";
			}
		}catch (Exception e) {
			System.out.println("여기맞나??");
			e.printStackTrace();
			ra.addAttribute("loginFail","이메일 혹은 비밀번호를 확인해주세요");
			return "redirect:/";
		}}
	
	//로그아웃 컨트롤러
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//핸드폰 추가 입력 컨트롤러
	@RequestMapping("/member/updatePhone")
	public String updatePhone(String memPhone, String memEmail) {
		memberLoginService.updatePhone(memEmail, memPhone);
		return "forward:/selectgroup/index";
	}
	
	//비밀번호 찾기 이메일 보내기 컨트롤러
	@RequestMapping("/member/login/sendEmail")
	public String changeEmail(String memEmail, Model model) {
		//없는 이메일 처리 
		MemVo memVo = memberLoginService.getOneMem(memEmail);
		if(memVo == null) {
			model.addAttribute("findMsg","NotExistence");
			return "/find-password";
		}else {
			memberLoginService.mailTofindPwd(memEmail); // 메일 인증 보내기
			return "redirect:/emailConfirm";
		}
	}
	
	//이메일 인증후 새로운 비밀번호 설정
	@RequestMapping("/member/login/emailConfirmNewPwd")
	public String newPwd(String key, String email, Model model) {
		int n = memberLoginService.authConfirm(key, email);
		if(n>0) {
			model.addAttribute("email",email);
			return "/setNewPwd";
		}else {
			System.out.println("새로운 비밀번호 설정 오류");
			return "redirect:/";
		}
	}
	
	//새로운 비밀번호 받아 암호화 처리후 업데이트
	@RequestMapping(value="/member/login/changePwd", method=RequestMethod.POST)
	public String changePwd(String newPwd, String email, Model model) {
		 String encPwd = passwordEncoder.encode(newPwd);
		 try {
			 memberLoginService.changeNewPwd(email, encPwd);
			 return "redirect:/";
		 }catch (Exception e) {
			 System.out.println(e.getMessage());
			 return "redirect:/";
		 }
		 
	}
}


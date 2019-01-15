package com.coduck.pond.group.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coduck.pond.core.utils.JsonParseString;
import com.coduck.pond.core.utils.PropertyUtility;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.service.GroupUpdateService;

@Controller
public class KakaoApiController {
	@Autowired
	private GroupService groupSerivce;
	@Autowired
	private GroupUpdateService groupUpdateSerivce;
	
	/*
	 * 최초에 주소 입력과 수정 같이 처리
	 * updateOk 라는 컬럼으로 분개
	 */
	
	@RequestMapping("/group/kakao/addr")
	public String kakao(String address, String groupNum, @RequestParam(defaultValue="false",value="updateOk") String updateOk, HttpServletResponse response, Model model) {
		String kakaoKey = new PropertyUtility().getPropertiesValue("kakaoKey", "kakao.properties");
		Map<String, String> map = new HashMap<>();
		try {
			String query = URLEncoder.encode(address , "UTF-8");
			String apiURL = "https://dapi.kakao.com/v2/local/search/address.json?query="+query;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "KakaoAK "+kakaoKey);
			int responseCode = con.getResponseCode();
			System.out.println(responseCode);
			InputStream is;
			if (con.getResponseCode() >= 400) {
			    is = con.getErrorStream();
			} else {
			    is = con.getInputStream();
			}
			
			String line;
			String rsp = "";
			BufferedReader reader = new BufferedReader(new  InputStreamReader(is));   
			while ((line = reader.readLine()) != null) {
			     rsp += line;
			}
			
			String x = new JsonParseString().parseWord("\"x\"", rsp.toString());
			String y = new JsonParseString().parseWord("\"y\"", rsp.toString());
			reader.close();
			
			
			try {
				if(updateOk.equals("false")) {
					groupSerivce.updateGroupAddr(x, y, address, groupNum);
				}else {
					groupUpdateSerivce.updateGroupAddr(address,x,y, groupNum);
					model.addAttribute("updateMsg","ok");
					return "forward:/group/detail/setting";
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "forward:/";
	}

}

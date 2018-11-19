package com.coduck.pond.group.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.core.utils.PropertyUtility;
import com.coduck.pond.group.dao.GroupDao;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.service.GroupUpdateService;
import com.fasterxml.jackson.core.JsonParser;

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
	public String kakao(String address, String groupNum, @RequestParam(defaultValue="false",value="updateOk") String updateOk, HttpServletResponse response) {
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
			
			/*
			 * 코드 너무 지저분 나중에 리펙토링 연습 ㄱㄱ
			 */
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(rsp);
			JSONArray jsonArr = (JSONArray)jsonObj.get("documents");
			JSONObject jsonObj2 = (JSONObject)jsonArr.get(0);
			JSONObject jsonObj3 = (JSONObject)jsonObj2.get("address");
			String x = (String)jsonObj3.get("x");
			String y = (String)jsonObj3.get("y");
			reader.close();
			
			try {
				if(updateOk.equals("false")) {
					groupSerivce.updateGroupAddr(x, y, address, groupNum);
				}else {
					groupUpdateSerivce.updateGroupAddr(address,x,y, groupNum);
					return "forward:/";
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

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.group.dao.GroupDao;
import com.coduck.pond.group.service.GroupService;
import com.fasterxml.jackson.core.JsonParser;

@Controller
public class KakaoApiController {
	@Autowired
	private GroupService groupSerivce;
	
	@RequestMapping("/group/kakao/addr")
	public String kakao(String address, String groupNum, HttpServletResponse response) {
		Map<String, String> map = new HashMap<>();
		try {
			String query = URLEncoder.encode(address , "UTF-8");
			String apiURL = "https://dapi.kakao.com/v2/local/search/address.json?query="+query;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", "KakaoAK 4367b0083ebf24a0e998f59f87f01bdf");
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
			
			System.out.println(rsp);
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject)parser.parse(rsp);
			JSONArray jsonArr = (JSONArray)jsonObj.get("documents");
			System.out.println(jsonArr);
			JSONObject jsonObj2 = (JSONObject)jsonArr.get(0);
			JSONObject jsonObj3 = (JSONObject)jsonObj2.get("address");
			String x = (String)jsonObj3.get("x");
			String y = (String)jsonObj3.get("y");
			reader.close();
			
			try {
				groupSerivce.updateGroupAddr(x, y, address, groupNum);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "forward:/";
	}
	
	public String updateGroupPhone(String groupPhoneNum, String groupNum) {
		try {
			groupSerivce.updateGroupPhone(groupPhoneNum, groupNum);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "forward:/";
	}
}

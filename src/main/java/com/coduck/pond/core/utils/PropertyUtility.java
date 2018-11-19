package com.coduck.pond.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyUtility {
	private String value;
	/*
	 * 자바파일에서 key값으로 프로퍼티 밸류값 가져오기
	 */
	public String getPropertiesValue(String key, String propertiesFileName) {
		InputStream is = getClass().getResourceAsStream("/"+propertiesFileName);
		Properties props = new Properties();
		//파일 InputStream을 Properties 객체로 읽어온다.
		try {
			props.load(is);
			value = (String)props.get(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}

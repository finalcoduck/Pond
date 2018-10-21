package com.coduck.pond.core.utils;

/**
 * @Class : StringUtility
 * @설명 : StringUtility
 * @작성자 : PaDuckk
 */

public class StringUtility {
	
	/**
	 * 문자를 날짜 형식으로 변환 
	 * 예) 20161120 --> 2016.11.20
	 * 
	 * @param str, separator
	 * 
	 * @return
	 */
	public static String cnvtDateFormat(String str, String separator){
		
		if(str == null) str = "";
		else str = str.trim();
		
		StringBuffer sb = new StringBuffer();

		if(str.length() > 7){
			sb.append(str.substring(0, 4)).append(separator);
			sb.append(str.substring(4, 6)).append(separator);
			sb.append(str.substring(6));
		}
		else{
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * 문자를 시간 형식으로 변환
	 * 예) 235959 --> 23:59:59
	 * 
	 * @param str, separator
	 * @return
	 */
	public static String cnvtTimeFormat(String str, String separator){
		
		if(str == null) str = "";
		else str = str.trim();
		
		StringBuffer sb = new StringBuffer();

		if(str.length() > 5){
			sb.append(str.substring(0, 2)).append(separator);
			sb.append(str.substring(2, 4)).append(separator);
			sb.append(str.substring(4, 6));
		}
		else{
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * NULL은 Empty 값으로 변환
	 * @param str
	 * @return
	 */
	public static String cnvtEmpty(String str){
		if(str == null) return "";
		else return str.trim();
	}
	
	public static String cnvtEmpty(Object obj){
		if(obj == null) return "";
		else return ((String)obj).trim();
	}

}

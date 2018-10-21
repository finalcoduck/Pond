package com.coduck.pond.core.utils;

import javax.servlet.http.HttpServletRequest;


/**
 * @Class : ClientUtility
 * @설명 : 사용자정보Utility
 * @작성자 : PaDuckk
 */
public class ClientUtility {
	
	/**
	 * 사용자 단말의 IP조회
	 * @param request
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request){
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			   ip = request.getHeader("Proxy-CLient-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			   ip = request.getHeader("WL-Proxy-CLient-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			   ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			   ip = request.getHeader("HTTP_X_FORWARDED-FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			   ip = request.getRemoteAddr();
		}
		return ip;
	}
}

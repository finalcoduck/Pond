package com.coduck.pond.core.utils;

import java.util.List;

/**
 * @Class : ValidUtility
 * @설명 : 유효체크유틸리티
 * @작성자 : PaDuckk
 */

public class ValidUtility {
	
	/**
	 * Object Null 아니면 참 반환
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj){
		return !isNull(obj);
	}
	
	/**
	 * Object Null 이면 참 반환
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj){
		if(obj == null) return true;
		else return false;
	}
	
	public static boolean isNotEmptyList(List<?> l){
		if(l == null || l.size() < 1){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * String 빈값이면 참 반환
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.isEmpty() || str.length() == 0) return true;
		else return false;
	}
	
	/**
	 * String 빈값이 아니면 참 반환
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}

}

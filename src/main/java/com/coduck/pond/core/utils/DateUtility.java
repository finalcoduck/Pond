package com.coduck.pond.core.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * @Class : DateUtility
 * @설명 : 날짜Utility
 * @작성자 : PaDuckk
 */

public class DateUtility {
	
	/**
	 * 당일일 반환 타입: YYYY-MM-DD 
	 * 
	 * @param 
	 * @return String
	 * @throws
	 */
	public static String getCurrentDateHyphen(){
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-dd");

		return simpleDateFormat.format(date);
	}
	
	/**
	 * 당일일 반환 타입: YYYYMMDD
	 * 
	 * @param 
	 * @return String
	 * @throws
	 */
	public static String getCurrentDate(){
		
		DecimalFormat df = new DecimalFormat("00");
		Calendar currentCal = Calendar.getInstance();
		
		currentCal.add(currentCal.DATE, 0);
		
		String year = Integer.toString(currentCal.get(Calendar.YEAR));
		String month = df.format(currentCal.get(Calendar.MONTH) + 1);
		String day = df.format(currentCal.get(Calendar.DAY_OF_MONTH));
		
		StringBuffer sb = new StringBuffer();
		sb.append(year).append(month).append(day);
		
		return sb.toString();
	}

}

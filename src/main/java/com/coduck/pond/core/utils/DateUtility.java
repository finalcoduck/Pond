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
	
	/*
	 *  ex)2018-03-02
	 *  1803 < 이런식으로 만들기 
	 *  for fullcalendar
	 */
	public String splitDate(String scheduleStartDate) {
		String[] newDate = scheduleStartDate.split("-");
		String year = newDate[0].substring(0, 2);
		String month = newDate[1];
		String resultString = year + month;
		return resultString;
	}
	
	/*
	 *  util 타입 date 객체를 sql 타입 date 객체로 하루를 더해준 후 반환
	 */
	public java.sql.Date plus1day(Date day) {
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		c.add(Calendar.DATE, 1);
		day = c.getTime();
		java.sql.Date date = new java.sql.Date(day.getTime());
		return date;
	}

}

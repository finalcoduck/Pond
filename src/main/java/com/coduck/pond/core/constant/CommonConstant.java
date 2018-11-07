package com.coduck.pond.core.constant;


/**
 * @Class : CommonConstant
 * @설명 : 공통상수 정의
 * @작성자 : PaDuckk
 */

public class CommonConstant {
	
	/** Group Status**/
	public static final char MANAGER = 'M';
	public static final char STUDENT = 'S';
	
	/** Member Status**/
	public static final char ACTIVATE_MEM = 'A';
	public static final char DELETE_MEM = 'D';
	
	/** Board Type**/
	public static final char NOTICE = 'N';
	public static final char HOMEWORK = 'H';
	
	/** User Session Key **/
	public static final String USER_SESSION_KEY = "memDto";
	
	
	/** Max Board Count **/
	public static final int MAX_BOARD_COUNT = 5;
	
	
	/** TRUE & FALSE **/
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	
	/** Zero & One */
	public static final String STR_ZERO = "0";
	public static final String STR_ONE = "1";
	public static final int INT_ZERO = 0;
	public static final int INT_ONE = 1;
	public static final long LONG_ZERO = 0;
	public static final long LONG_ONE = 1;
	
	/** 처리코드(CRUD) */
	public static final String DELETE = "D";
	public static final String INSERT = "C";
	public static final String UPDATE = "U";
	
	
}

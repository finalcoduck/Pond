package com.coduck.pond.core.constant;

/**
 * @Class : CommonConstant
 * @설명 : 에러코드상수 정의
 * @작성자 : PaDuckk
 */

public class ErrorCodeConstant {
	/** 정상적으로 처리된 경우 */
	public static final String SUCCESS = "0000";
	
	/** 일반적인 실패  hi*/
	public static final String FAILURE = "E001";
	
	/** 중복으로 인한 오류 */
	public static final String DUPLICATED = "E002";
	
	/** 처리대상 미존재 */
	public static final String NOT_FOUND = "E003";	
	
	/** 이미 등록된 경우  */
	public static final String REGISTERED = "E004";
	
	/** 필수항목 오류 */
	public static final String EMPTY_REQUIRED = "E005";
	
	/** 권한부족 */
	public static final String UNAUTHORIZED = "E006";
	
	/** DB관련 오류 */
	public static final String DB_ERROR = "E007";
	
	/** 시스템오류 */
	public static final String SYSTEM_ERROR = "E008";
	
	/** 오류 */
	public static final String ERROR = "E009";
	
	
	
	/** 
	 * 로그인시 계정확인
	 * 로그인시 아이디와 비밀번호에 해당하는 계정 조회안됨 
	 */
	public static final String WRNG_ID_PWD = "E011";
	
	/**
	 * 비정상 계정
	 * 계정이 미승인상태이거나 퇴사 업무 전환된 경우
	 */
	public static final String ACCN_ABNRML = "E012";
	
	/** 계정잠김 */
	public static final String ACCN_LCK = "E013";

	/**
	 * 에러 메시지 반환
	 * @param errC
	 * @return
	 */
	public static String getMessage(String errC){
		String msg = "";
		
		switch (errC) {
			case SUCCESS:
				msg = "성공적으로 실행되었습니다.";
				break;
				
			case FAILURE:
				msg = "요청 처리에 실패하였습니다.";
				break;
				
			case DUPLICATED:
				msg = "요청이 중복되어 처리가 완료되지 못했습니다.";
				break;
				
			case NOT_FOUND:
				msg = "요청 대상이 존재하지않아 처리되지않았습니다.";
				break;
				
			case REGISTERED:
				msg = "이미 처리되었습니다.";
				break;
				
			case EMPTY_REQUIRED:
				msg = "필수 항목의 값이 없습니다.";
				break;
				
			case UNAUTHORIZED:
				msg = "권한이 없어서 처리되지않았습니다.";
				break;
				
			case DB_ERROR:
				msg = "DB 처리중에 오류가 발생하였습니다.";
				break;
				
			case SYSTEM_ERROR:
				msg = "시스템 오류가 발생하였습니다.";
				break;
				
			case ERROR:
				msg = "오류가 발생하였습니다.";
				break;
				
			case ACCN_ABNRML:
				msg = "계정이 비활성상태입니다. 담당자에게 문의하십시오.";
				break;
				
			case WRNG_ID_PWD:
				msg = "아이디와 비밀번호를 확인하십시오.";
				break;

			case ACCN_LCK:
				msg = "잠김계정입니다. 담당자에게 문의하십시오.";
				break;
	
			default:
				break;
		}
		return msg;
	}
	


}

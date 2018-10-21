package com.coduck.pond.core.constant;


// import static !! 
import static com.coduck.pond.core.constant.CommonConstant.*;
import com.coduck.pond.core.constant.ErrorCodeConstant;
//import static 할 경우 클래스명을 붙이지 않아도 됨

public class UseConstatantExample {
	
	public static void main(String[] args) {
		
		//static import의 경우
		String d = DELETE;
		
		//그냥 import의 경우
		String success = ErrorCodeConstant.SUCCESS;
		
		System.out.println(d);
		
		System.out.println(success);
	}
}

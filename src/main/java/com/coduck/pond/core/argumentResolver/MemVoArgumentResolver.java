package com.coduck.pond.core.argumentResolver;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.member.vo.MemDto;


public class MemVoArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		//파라미터 타입이 MemVo인지 체크 true일경우 argument가 주입됨
		return parameter.getParameterType()==MemDto.class;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		
		//webRequest 객체의  세션스코프에서  키가 "memVo"인걸 꺼내옴
		MemDto memDto =  (MemDto)webRequest.getAttribute(CommonConstant.USER_SESSION_KEY,webRequest.SCOPE_SESSION);
		
		return memDto;
	}

}

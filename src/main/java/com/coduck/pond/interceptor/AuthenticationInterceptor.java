package com.coduck.pond.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.coduck.pond.member.vo.MemDto;

public class AuthenticationInterceptor implements HandlerInterceptor{
	
	/*
	 *  로그인 상태 확인
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("확인 테스트!!!!!!");
		HttpSession session = request.getSession();
		MemDto memDto = (MemDto)session.getAttribute("memDto");
		if(memDto == null) {
			response.sendRedirect("/");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

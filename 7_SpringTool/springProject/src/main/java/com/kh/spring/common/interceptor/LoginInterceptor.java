package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	/*
	 * * Interceptor (HandlerInterceptor)
	 * 		- 요청 url에 해당하는 Controller가 실행되기 전 또는 후에 실행할 내용 작성
	 * 		- 로그인 유/무 판단, 회원의 권한 체크 등
	 * 	preHandle : DispatcherServlet이 Controller를 호출하기 전 처리하는 영역(전처리)
	 * 	postHandle : Controller 처리 후 DispatcherServlet으로 view 정보를 리턴하는 순간 처리하는 영역(후처리)
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// true 리턴 : 기존 방식대로 controller가 실행
		// false 리턴 : controller를 실행하지 않음
		HttpSession session = request.getSession();
		// 로그인 한 상태인 경우 기존대로 controller 실행
		if (session.getAttribute("loginUser") != null) {
			return true;
		// 로그인 상태가 아닌 경우 controller 실행x, 메인 페이지 재요청
		} else {
			session.setAttribute("alertMsg", "로그인 후 이용 가능합니다.");
			response.sendRedirect(request.getContextPath());
			return false;
		}
	}
	
}
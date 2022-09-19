package web.bbs.intercepter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.SessionConst;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		
		String requestURI = request.getRequestURI();
		
		Enumeration<String> parameterNames = request.getParameterNames();
		String queryString = request.getQueryString();
		HttpSession session = request.getSession(false);
		log.info(" requestURI = {} , session ={}, attribute ={}" ,requestURI, session,request.getAttribute(SessionConst.Login_session));
		log.info("여기 reqeust.url값 : {}" , request.getRequestURL() );
		log.info("request.getQueryString:{}", request.getQueryString());
		log.info("request.getparameter;{}", request.getParameterNames());
		if(session == null || session.getAttribute(SessionConst.Login_session) == null) {
			if(queryString != null) {
				response.sendRedirect("/home/login/form?redirectURL=" + requestURI+"?" + queryString);	
			}else {
				response.sendRedirect("/home/login/form?redirectURL=" + requestURI);
			}
						
			return false;
		}
		session.setAttribute("sess", session);		
		log.info("session={}",session);
				
		return true;
					
	}


	
	
}

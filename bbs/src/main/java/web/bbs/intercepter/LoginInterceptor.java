package web.bbs.intercepter;

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
		HttpSession session = request.getSession(false);
		log.info(" requestURI = {} , session ={}, attribute ={}" ,requestURI, session,request.getAttribute(SessionConst.Login_session));
		if(session == null || session.getAttribute(SessionConst.Login_session) == null) {
			response.sendRedirect("/home/login/form?redirectURL=" + requestURI);
			return false;
		}
		request.setAttribute("sess", session);
		return true;
					
	}


	
	
}

package web.bbs.intercepter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.SessionConst;

@Slf4j
public class MemberDtoIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session.getAttribute(SessionConst.Login_session) != null && session != null ) {
			request.setAttribute("member", session.getAttribute(SessionConst.Login_session));
			
			return true;
		}
			return false;
	}

	
	
}

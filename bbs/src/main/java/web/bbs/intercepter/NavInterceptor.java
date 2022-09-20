package web.bbs.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import web.bbs.domain.Nav;

public class NavInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		request.setAttribute("logInUri", Nav.LOGNIN_NAV);
		request.setAttribute("signUpUri", Nav.SIGNUP_NAV);
		request.setAttribute("bbsUri", Nav.BBS_NAV);
		request.setAttribute("logOutUri", Nav.LOGOUT_NAV);
		request.setAttribute("homeUri", Nav.HOME_NAV);
		request.setAttribute("shopUri",Nav.SHOP_NAV );
		
		return true;
	}


	
}

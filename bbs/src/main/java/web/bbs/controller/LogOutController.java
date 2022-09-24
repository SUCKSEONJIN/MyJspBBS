package web.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class LogOutController {
	
	@GetMapping("/home/logOut")
	public String logOUt(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		log.info("로그아웃 성공");
		
		return "redirect:/";
	}
	
}

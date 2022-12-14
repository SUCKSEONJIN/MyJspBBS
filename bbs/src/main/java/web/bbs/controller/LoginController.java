package web.bbs.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.domain.MemberLoginDTO;
import web.bbs.repository.member.MemberRepository;
import web.bbs.service.LoginService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/home/login")
public class LoginController {
	private final LoginService loginService;
	@GetMapping("/form")
	public String loginform(@ModelAttribute("member") MemberLoginDTO member, Model model, HttpServletRequest request) {
		model.addAttribute("member", new MemberLoginDTO());
		StringBuffer requestURL = request.getRequestURL();
		String queryString = request.getQueryString();
	
		if(queryString != null) {
			int index = queryString.indexOf("=");
			String substring = queryString.substring(index+2);					
			model.addAttribute("url",substring);								
		}else {
			model.addAttribute("url",queryString);
		}
		return "login"; 
	}
	
	@PostMapping("/form")
	public String loginformLogin(@Valid @ModelAttribute("member") MemberLoginDTO member, BindingResult bindingResult
			, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect) {
		boolean alert = false;
		if(bindingResult.hasErrors()) {
			log.error("error 발생");
			return "login";
		}
							
		Member passedMember = loginService.loginProcess(request, response, member);
		if(passedMember == null) {
			bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않습니다.");
			return "login";
		}			
		
		alert = true;
		redirect.addFlashAttribute("check", alert);
		redirect.addFlashAttribute("member1",passedMember);				
		String url = request.getQueryString();		
		int index = url.indexOf("=");
		String subString = url.substring(index +1);		
		if(url != null) {return "redirect:/" + subString;}		
		return "redirect:/";
	}
	
}

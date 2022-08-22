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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;
import web.bbs.service.LoginService;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/home/login")
public class LoginController {

	private final MemberRepository memberRepository;	
	private final LoginService loginService;
	
	@GetMapping("/form")
	public String loginform(@ModelAttribute("member") Member member, Model model) {
		model.addAttribute("member", new Member());		
		return "login"; 
	}
	
	@PostMapping("/form")
	public String loginformLogin(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult
			, HttpServletRequest request, HttpServletResponse response, Model model) {
		boolean alert = false;
		if(bindingResult.hasErrors()) {
			return "login";
		}
				
		loginService.loginProcess(request, response, member);
		alert = true;
		model.addAttribute("check", alert);
		return "redirect:/";
	}
	

}

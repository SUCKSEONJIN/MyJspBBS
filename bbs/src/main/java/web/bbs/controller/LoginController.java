package web.bbs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/home/login")
public class LoginController {

	private final MemberRepository memberRepository;	
	
	@GetMapping("/form")
	public String loginform(Model model) {
		model.addAttribute("member", new Member());		
		return "login"; 
	}
	
	@PostMapping("/form")
	public String loginformLogin(@ModelAttribute("member") Member member) {
		
		return "redirect:/";
	}
	

}

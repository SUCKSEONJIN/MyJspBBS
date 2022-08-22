package web.bbs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value="/home/signUp")
public class SignupController {
	private final MemberRepository memberRepository;
	
	@GetMapping("/form")
	public String signUp_form(Model model) {
		model.addAttribute("member",new Member());
		return "signUp";
	}
	
	@PostMapping("/form")
	public String signUp_formPost(@Valid @ModelAttribute("member") Member member,
			BindingResult result, RedirectAttributes redirect) {
	
		boolean signUpCheck = false;
		if(result.hasErrors() == true) {
			return "signUp";
		}
		memberRepository.save(member);
		log.info("member.name ={}",memberRepository.findById(member.getId()).getName());
		redirect.addAttribute("signUpCheck",signUpCheck);
				
		return "redirect:/";
	}
}

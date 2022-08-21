package web.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final MemberRepository memberRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String navCheck(@ModelAttribute("member") Member member, Model model) {		
		model.addAttribute("member", member);		
		return "home";
	}
}

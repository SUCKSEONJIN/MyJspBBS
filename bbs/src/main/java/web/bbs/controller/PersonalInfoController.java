package web.bbs.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import web.bbs.domain.Member;
import web.bbs.domain.MemberUpdateDTO;
import web.bbs.repository.member.MemberRepository;


@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class PersonalInfoController {
	
	private final MemberRepository memberRepository;
	
	@GetMapping("/memberInfo")
	public String memberInfo_get(Model model, HttpServletRequest request) {		
		model.addAttribute("member",request.getAttribute("member"));				
		return "memberInfo";
	}
	
	@PostMapping(value="/memberInfo" , params = "modification")
	public String memberInfo_post_modification(@ModelAttribute("member") Member member, RedirectAttributes redirect, HttpServletRequest request){
		MemberUpdateDTO dto = new MemberUpdateDTO();
		dto.setEmail(member.getEmail());
		dto.setPassword(member.getPassword());
		Member sameMember = (Member)request.getAttribute("member");
		
		memberRepository.update(sameMember.getId(), dto);
		return "redirect:/home/memberInfo";
	}
	
	@PostMapping(value="/memberInfo", params = "home")
	public String memberInfo_post_home() {
		return "redirect:/";
	}
	
}

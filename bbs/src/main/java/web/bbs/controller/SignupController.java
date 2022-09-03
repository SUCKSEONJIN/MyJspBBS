package web.bbs.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.xdevapi.JsonArray;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.WebMysqlConfig;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;

@Controller
@Slf4j
@RequestMapping(value="/home/signUp")
public class SignupController {
	
	private final MemberRepository memberRepository;
//	public SignupController() {
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(WebConfig.class);
//		MemberRepository bean = ac.getBean("memberRepository", MemberRepository.class);
//		memberRepository = bean;
//
//	}
	
	@Autowired
	public SignupController(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@PostConstruct
	public void example() {
		Member member = new Member();
		member.setName("석선진");
		member.setAge(30);
		member.setEmail("wlq862@naver.com");
		member.setPassword("123123123");
		member.setUserId("spring1");
		member.setBbsDataId(new ArrayList<>());
		
		memberRepository.save(member);
		
		Member member1 = new Member("석후진",30,"wlq123@naver.com","123123123","spring2");
		member1.setBbsDataId(new ArrayList<>());
		memberRepository.save(member1);
	}
	
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
	
		redirect.addAttribute("signUpCheck",signUpCheck);
				
		return "redirect:/";
	}
}

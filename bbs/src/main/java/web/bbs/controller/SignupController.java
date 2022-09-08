package web.bbs.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//		Member member = new Member();
//		member.setName("석선진");
//		member.setAge(30);
//		member.setEmail("wlq862@naver.com");
//		member.setPassword("123123123");
//		member.setUserId("spring1");
//		
//		
//		memberRepository.save(member);
//		
//		Member member1 = new Member("석후진",30,"wlq123@naver.com","123123123","spring2");		
//		memberRepository.save(member1);
	}
	
	@GetMapping("/form")
	public String signUp_form(Model model, HttpServletRequest request, @RequestParam(required=false ,value="check") String check) {
		
		model.addAttribute("member",new Member());		
		
		//model.addAttribute("check",check);
		return "signUp";
	}
	
	@PostMapping("/form")
	public String signUp_formPost(@Valid @ModelAttribute("member") Member member,
			BindingResult result, RedirectAttributes redirect) {
	
		boolean signUpCheck = false;
		if(result.hasErrors() == true) {
			return "signUp";
		}
		try{
			memberRepository.save(member);
		}catch (Exception e) {
			log.error("회원가입 에러 message ={}" ,e.getMessage());
			return "signUp";
		}
	
		redirect.addAttribute("signUpCheck",signUpCheck);
				
		return "redirect:/";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST,params="du")
	public String signUp_formPost_duplicated(@Valid @ModelAttribute("member") Member member1,
			BindingResult result, RedirectAttributes redirect, HttpServletRequest request,Model model) {
		log.info("du 실행중");
		Optional<Member> member_o = memberRepository.findByLoginId(member1.getUserId());
		Member member = member_o.orElse(null);
		model.addAttribute("status",true);
		if(member != null) {
			model.addAttribute("check",false);			
			log.info("중복값이 있습니다.");
			return "signUp";
		}
		
		//redirect.addAttribute("check", true);
		model.addAttribute("check", true);
		log.info("중복값이 없습니다.");
		return "signUp";
	}
	
	@PostMapping("/duplilcatedLoginId")
	public String checkDuplicatedUserIdLogic(@RequestParam("userId") String userId) {
		Optional<Member> member = memberRepository.findByLoginId(userId);
		member.orElse(null);
		return "signUp";
	}
	
	@RequestMapping(value="/duplicateCheck")
	public String checkDuplicationUserIdWindow(Model model) {		
		model.addAttribute("duplicatedCheck",true);
		return "/duplicatedUserIdWindow";
	}
}

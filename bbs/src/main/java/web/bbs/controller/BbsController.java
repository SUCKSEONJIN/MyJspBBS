package web.bbs.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.Member;
import web.bbs.repository.member.MemberRepository;
import web.bbs.service.BbsService;

@Slf4j
@Controller
@RequestMapping("/home/bbs")
@RequiredArgsConstructor
public class BbsController {
				
	private final MemberRepository memberRepository;
	private final BbsService bbsService;
	

	@RequestMapping
	public String viewBbs(@ModelAttribute("member") Member member, Model model){		
		List<BbsData> bbsDatas = bbsService.BbsView();
		model.addAttribute("member",member);
		log.info("viewBbs member.getName={}", member.getName());
		model.addAttribute("bbsDatas", bbsDatas);		
		return "bbs";
	}
	
	@GetMapping("/write")
	public String inputBbs(@ModelAttribute("bbsData") BbsData bbsData, @ModelAttribute("member") Member member,
			Model model) {
		model.addAttribute("member",member);
		log.info("member={}", member);
		model.addAttribute("bbsData", new BbsData());
		return "bbsInputForm";
	}

	@PostMapping("/write")
	public String inputBbs_logic(@ModelAttribute("bbsData") BbsData bbsData) {
		bbsService.bbsSave(bbsData);		
		return "redirect:/home/bbs";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

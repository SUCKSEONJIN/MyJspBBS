package web.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String viewBbs(HttpServletRequest request, Model model){		
		Member member = (Member)request.getAttribute("member");
		List<BbsData> bbsDatas = bbsService.BbsView(new BbsData());
		model.addAttribute("member",member);
		log.info("viewBbs member.getName={}", member.getName());
		model.addAttribute("bbsDatas", bbsDatas);		
		return "bbs";
	}
	
	@GetMapping("/write")
	public String inputBbs(@ModelAttribute("bbsData") BbsData bbsData, HttpServletRequest request, 
			Model model) {
		Member member = (Member) request.getAttribute("member");
		model.addAttribute("member",member);
		log.info("member.getName()={}", member.getName());
		model.addAttribute("bbsData", new BbsData());
		return "bbsInputForm";
	}

	@PostMapping("/write")
	public String inputBbs_logic(@Valid @ModelAttribute("bbsData") BbsData bbsData, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors() == true) {
			return "bbsInputForm";
		}
		bbsData.setTime(createTime());
		bbsService.bbsSave(bbsData,request);		
		return "redirect:/home/bbs";
	}
	
	public String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String date = formatter.format(now);	
		return date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

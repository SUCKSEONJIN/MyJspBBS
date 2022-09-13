package web.bbs.controller;



import java.util.ArrayList;import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController {
	
	
	@ModelAttribute
	public void pageNumberVarible(Model model) {
		
		Integer numberViewCount = 5;
		Integer pageNumberLast = 9;
		
		if(pageNumberLast > numberViewCount) {
			model.addAttribute("pageNumberLast",numberViewCount);
		}else{
			model.addAttribute("pageNumberLast",pageNumberLast);		
		}
		model.addAttribute("originalLast", pageNumberLast);
	}
	
	@GetMapping("/test")
	public String sendNum(Model model) {					
		model.addAttribute("num",0);
		return "test";
	}
	
	@PostMapping(value="/test/page", params="previous")
	public String sendStat(@RequestParam(value="count", required=false) Integer count,Model model,@RequestParam(value="rest", required=false) Integer rest,
			RedirectAttributes redirect) {
		log.info("rest값 ={}",rest);
		if(rest > 0) {
			redirect.addAttribute("num", count-1);				
		}else {
			redirect.addAttribute("num",count);
		}
		return "redirect:/test/page";
	}
	
	@PostMapping(value="/test/page", params="next")
	public String sendStatPost(Model model,@RequestParam(value= "count", required=false) Integer count,
			RedirectAttributes redirect, @RequestParam(value="originalLast", required=false)Integer originalLast,
			@RequestParam(value="rest", required=false) Integer rest ) {
		
		
		if(originalLast > 5 && (rest+5) < originalLast) {
			
			redirect.addAttribute("num",count+1);					
		}else {
			redirect.addAttribute("num",count);
		}
		
		log.info("rest의 값 = {}",rest);
		
		return "redirect:/test/page";
	}
	@GetMapping("/test/page")
	public String sendStatNext(Model model, @RequestParam(value="num", required=false) Integer num) {		
		model.addAttribute("stat",true);
		model.addAttribute("num",num);
		return "test";
	}
	
	
	
	
	
	
	
	
}

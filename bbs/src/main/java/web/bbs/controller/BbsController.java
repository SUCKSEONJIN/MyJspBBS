package web.bbs.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.bbs.domain.BbsData;
import web.bbs.domain.BbsData_update;
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
	
	private Integer pageNumberLast = 0;

	@RequestMapping("/{currentPageNumber}")
	public String viewBbs(@PathVariable("currentPageNumber") Integer currentPageNumber,HttpServletRequest request, Model model){		
		Member member = (Member)request.getAttribute("member");
		List<BbsData> list = bbsService.bbsDataSum();
		List<BbsData> subList = null;
		int size = list.size();
		if(size/10 == 0) {
			pageNumberLast = size / 10;		
		}else {
			pageNumberLast = size / 10 + 1;
		}
		int lastIndex = size-1;
		int oneValue = bbsService.intOneValueExtract(size);
		int lastLimit = 9+(10*(currentPageNumber-1));
		if(lastIndex >= lastLimit) {		
			subList = list.subList(0+(10*(currentPageNumber-1)), lastLimit+1);			
		}else {
			subList = list.subList(0+(10*(currentPageNumber-1)), oneValue+(10*(currentPageNumber-1)));
		}
		model.addAttribute("ampt",1);
		model.addAttribute("member", member);
		model.addAttribute("bbsDatas", subList);
		model.addAttribute("currentPageNumber",currentPageNumber);			
		model.addAttribute("num",0);			

		return "bbs";
	}
	
	@GetMapping("/write")
	public String inputBbs(@ModelAttribute("bbsData") BbsData bbsData, HttpServletRequest request, 
			Model model,@RequestParam("currentPageNumber") Integer currentPageNumber) {
		Member member = (Member) request.getAttribute("member");
		model.addAttribute("member",member);
		log.info("member.getName()={}", member.getName());
		model.addAttribute("bbsData", new BbsData());
		model.addAttribute("currentPageNumber",currentPageNumber);
		log.info("current 여기:{}", currentPageNumber);
		log.info("request.geturl:{}",request.getRequestURL());
		log.info("request.getquery:{}", request.getQueryString());
		return "bbsInputForm";
	}

	@PostMapping("/write")
	public String inputBbs_logic(@Valid @ModelAttribute("bbsData") BbsData bbsData, BindingResult result, HttpServletRequest request,
			@RequestParam(value="currentPageNumber", required=false) Integer currentPageNumber,
			RedirectAttributes redirect) {
		
		if(result.hasErrors() == true) {
			return "bbsInputForm";
		}
		bbsData.setTime(createTime());
		redirect.addAttribute("currentPageNumber",currentPageNumber);
		bbsService.bbsSave(bbsData,request);		
		return "redirect:/home/bbs/{currentPageNumber}";
	}	
	
	public String createTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String date = formatter.format(now);	
		return date;
	}
	
	//pagination
	@ModelAttribute
	public void pageNumberVarible(Model model) {
		
		List<BbsData> list = bbsService.bbsDataSum();
		
		int size = list.size();
		if(size/10 == 0) {
			pageNumberLast = size / 10;		
		}else {
			pageNumberLast = size / 10 + 1;
		}
		
		Integer numberViewLimit = 5;
		
		if(pageNumberLast > numberViewLimit) {
			model.addAttribute("pageNumberLast",numberViewLimit);
		}else{
			log.info("pageNumberLast 값 : {}", pageNumberLast);
			model.addAttribute("pageNumberLast",pageNumberLast);		
		}
		model.addAttribute("originalLast", pageNumberLast);
	}
	
	
	@PostMapping(value="/page", params="previous")
	public String sendStat(@RequestParam(value="count", required=false) Integer count,Model model,@RequestParam(value="pageNum", required=false) Integer pageNum,
			@RequestParam(value="currentPageNumber", required = false) Integer currentPageNumber,RedirectAttributes redirect) {
		log.info("rest값 ={}",pageNum);
		if(pageNum > 0) {
			redirect.addAttribute("num", count-1);				
		}else {
			redirect.addAttribute("num",count);
		}
		
		int minus; 
		if(currentPageNumber > 1) minus = -1;else {minus=0;} 						
		redirect.addAttribute("currentPageNumber", currentPageNumber+minus);
		return "redirect:/home/bbs/{currentPageNumber}";// pageNumber값 아직 받지 못했음.
	}
	
	@PostMapping(value="/page", params="next")
	public String sendStatPost(Model model,@RequestParam(value= "count", required=false) Integer count,
			RedirectAttributes redirect, @RequestParam(value="originalLast", required=false)Integer originalLast,
			@RequestParam(value="pageNum", required=false) Integer pageNum,@RequestParam(value="currentPageNumber", required=false) Integer currentPageNumber
			) {
			
		if(originalLast > 5 && (pageNum+5) < originalLast) {			
			redirect.addAttribute("num",count+1);					
		}else {
			redirect.addAttribute("num",count);
		}
		
		log.info("pageNum의 값 = {}",pageNum);
		int add;
		if(originalLast > currentPageNumber) add = 1;else add = 0;
		log.info("oiriginallast value:{}",originalLast);
		
		redirect.addAttribute("currentPageNumber",currentPageNumber+add);
		return "redirect:/home/bbs/{currentPageNumber}";//pgaeNumber값 아직 받지 못했음. 
	}
	
	
	// bbsData view 
	
	@RequestMapping(value="/bbsData/{bbsDataId}", method = RequestMethod.GET)	
	public String bbsDataView(@PathVariable("bbsDataId") Long bbsDataId, Model model,
			@RequestParam("currentPageNumber")Integer currentPageNumber) {
		BbsData bbsData = bbsService.bbsDataView(bbsDataId);
		model.addAttribute("bbsData",bbsData);
		model.addAttribute("bbsDataId", bbsDataId);
		model.addAttribute("currentPageNumber",currentPageNumber);
		return "bbsDataViewForm"; 
	}
		
	@GetMapping(value="/modify", params="list")
	public String bbsDataModify_list(@RequestParam("currentPageNumber") Integer currentPageNumber,
			RedirectAttributes redirect) {
		log.info("리스트 작동중");
		redirect.addAttribute("currentPageNumber",currentPageNumber);
		return "redirect:/home/bbs/{currentPageNumber}";
	}
	
	@GetMapping(value="/modify", params="modify")
	public String bbsDataModify_modify(Model model,@RequestParam("currentPageNumber") Integer currentPageNumber,			
		@RequestParam("id") Long id) {
		
		BbsData bbsData = bbsService.bbsDataView(id);
		model.addAttribute("currentPageNumber", currentPageNumber);
		model.addAttribute("bbsData", bbsData);
		return "bbsModifyForm";
	}
	
	@PostMapping(value="/modify",params="check")
	public String bbsDataModifyCheck(@ModelAttribute("bbsData")BbsData bbsData,Model model,
			@RequestParam("currentPageNumber") Integer currentPageNumber, RedirectAttributes redirect) {
		BbsData_update updateData = new BbsData_update();
		updateData.setTitle(bbsData.getTitle());
		updateData.setText(bbsData.getText());
		updateData.setTime(createTime());
		log.info("업데이트 id값 = {}", bbsData.getId());
		bbsService.bbsDataModify(bbsData.getId(), updateData);
		redirect.addAttribute("currentPageNumber",currentPageNumber);
		
		return "redirect:/home/bbs/{currentPageNumber}";		
	}
	
	@PostMapping(value="/modify",params="list")
	public String bbsDataModifyCancel(@RequestParam("currentPageNumber")Integer currentPageNumber, 
			RedirectAttributes redirect) {
		redirect.addAttribute("currentPageNumber", currentPageNumber);
		return "redirect:/home/bbs/{currentPageNumber}";
	}
	

	
	
}

package web.bbs.controller;

import java.io.File;
import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.util.UriUtils;

import web.bbs.domain.Member;
import web.bbs.domain.ShopData;

@Controller
@RequestMapping("/home/shop")
public class ShopController {

	
	
	@GetMapping("/shopDataForm")
	public String shopDataView(Model model){
		model.addAttribute("file", Path.of(null));
		model.addAttribute("shopData",new ShopData());		
		return "shopDataView";		
	}
	
	@RequestMapping(value="/shopDataForm", params ="check" )
	public String shopDataProcess(@ModelAttribute("shopData") ShopData shopData) {
		
		
		return "redirect:/home/shop/shopList";
	}
	
	@GetMapping("/shopList")
	public String shopDataListView() {
		
		return "";
	}
	
	
	
}

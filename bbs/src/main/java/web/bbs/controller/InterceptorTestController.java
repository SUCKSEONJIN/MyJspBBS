package web.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InterceptorTestController {
	
	@GetMapping("/test/first")	
	public String first() {
		log.info("first 작동");
		return "test";
	}
	
	@GetMapping("/test/second")
	public String second() {
		log.info("second 작동");
		return "test";
	}
}

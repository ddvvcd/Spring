package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	//"/" : 시작페이지
	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)//페이지 불러오는 메서드 작성(페이지명으로 쓰기) 
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/annotation/param"; //주소 바뀜
	}

	@GetMapping("/forward")
	public String forward() {
		return "forward:/annotation/model"; //주소 고정
	}

	
}

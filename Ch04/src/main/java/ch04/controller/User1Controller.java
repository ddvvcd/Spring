package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class User1Controller {
	
	@RequestMapping(value="/user1/register", method=RequestMethod.GET)
	public String register() {
		return "/user1/register";
	}
	
	@RequestMapping(value="/user1/register", method=RequestMethod.POST)
	public String register(@RequestParam("uid") String uid, 
						   @RequestParam("name") String name,
						   @RequestParam("hp") String hp,
						   @RequestParam("age") int age) {
		
		System.out.println("uid : " + uid);
		System.out.println("name : " + name);
		System.out.println("hp : " + hp);
		System.out.println("age : " + age);
		
		//스프링 redirect
		return "redirect:/Ch04/index";
	}
}

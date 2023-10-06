package kr.ch10.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch10.dto.User5DTO;
import kr.ch10.service.user.MyUser5Service;



@Controller
public class MyUser5Controller {
	
	@Autowired
	private MyUser5Service service;
	
	@GetMapping("/user5/list")
	public String list(Model model) { //인터페이스 Model
		
		List<User5DTO> users = service.selectUser5s();
		model.addAttribute("users", users);
		
		return "/user5/list";
	}
	
	@GetMapping("/user5/register")
	public String register() {
		return "/user5/register";
	}
	
	@PostMapping("/user5/register")
	public String register(User5DTO dto) {
		
		service.insertUser5(dto);
		
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/modify")
	public String modify(String name, Model model) {
		
		User5DTO user5 = service.selectUser5(name);
		model.addAttribute("user", user5);
		
		return "/user5/modify";
	}
	
	@PostMapping("/user5/modify")
	public String modify(User5DTO dto) {
		service.updateUser5(dto);
		return "redirect:/user5/list";
	}
	
	@GetMapping("/user5/delete")
	public String delete(String name) {
		service.deleteUser5(name);
		return "redirect:/user5/list";
	}
}
package kr.ch10.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ch10.dto.User2DTO;
import kr.ch10.service.user.MyUser2Service;

@Controller
public class MyUser2Controller {
	
	@Autowired
	private MyUser2Service service;
	
	@GetMapping("/user2/list")
	public String list(Model model) { //인터페이스 Model
		
		List<User2DTO> users = service.selectUser2s();
		model.addAttribute("users", users);
		
		return "/user2/list";
	}
	
	@GetMapping("/user2/register")
	public String register() {
		return "/user2/register";
	}
	
	@PostMapping("/user2/register")
	public String register(User2DTO dto) {
		
		service.insertUser2(dto);
		
		return "redirect:/user2/list";
	}
	
	@GetMapping("/user2/modify")
	public String modify(String id, Model model) {
		
		User2DTO user2 = service.selectUser2(id);
		model.addAttribute("user", user2);
		
		return "/user2/modify";
	}
	
	@PostMapping("/user2/modify")
	public String modify(User2DTO dto) {
		service.updateUser2(dto);
		return "redirect:/user2/list";
	}
	
	@GetMapping("/user2/delete")
	public String delete(String id) {
		service.deleteUser2(id);
		return "redirect:/user2/list";
	}
}

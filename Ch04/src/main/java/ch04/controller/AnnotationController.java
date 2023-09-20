package ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch04.dto.ModelDTO;

@Controller
public class AnnotationController {
	
	@RequestMapping(value="/annotation/param", method=RequestMethod.GET)
	public String param() {
		return "/annotation/param";
	}
	
	@RequestMapping(value="/annotation/param1", method=RequestMethod.POST)
	public String param1(@RequestParam("uid") String uid, Model model) {
		
		//콘솔창에 출력해봄
		System.out.println("uid : " + uid);
		
		//모델 참조를 통한 View 데이터 출력
		model.addAttribute("uid", uid);
		
		return "/result/param";
	}
	
	@PostMapping("/annotation/param2") //순서에 맞게 넣지 않아도 알아서 정렬함
	public String param2(Model model, @RequestParam("uid") String uid, String name) {
		
		System.out.println("uid : " + uid);
		System.out.println("name : " + name);
		
		model.addAttribute("uid", uid);
		model.addAttribute("name", name);
		
		return "/result/param";
	}
	
	@PostMapping(value="/annotation/param3") //순서에 맞게 넣지 않아도 알아서 정렬함
	public String param3(String uid, int age, String name, String hp, Model model) {
		
		model.addAttribute("uid", uid);
		model.addAttribute("age", age);
		model.addAttribute("name", name);
		model.addAttribute("hp", hp);
		
		return "/result/param";
	}
	
	@GetMapping("/annotation/model")
	public String model() {
		return "/annotation/model";
	}
	
	@PostMapping("/annotation/model1")
	public String model1(@ModelAttribute ModelDTO dto) {
		return "/result/model";
	}
	
	@PostMapping("/annotation/model2")
	public String model2(@ModelAttribute("user") ModelDTO dto) {
		return "/result/model";
	}
	
	@PostMapping("/annotation/model3")
	public String model3(@ModelAttribute ModelDTO dto) {
		return "/result/model";
	}
}
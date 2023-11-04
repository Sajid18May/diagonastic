package com.diagonastictest.diagonastic.webController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diagonastictest.diagonastic.Entity.DiagnosticTests;
import com.diagonastictest.diagonastic.Entity.Patients;

@Controller
public class homeController {

	@GetMapping("/homepage")
	public String greeting(){
		return "index";
	}
		
	@GetMapping("/test")
	public String test(Model model){
		model.addAttribute("testform", new DiagnosticTests());
		return "test";
	}
	@GetMapping("/about")
	public String about(){
		return "about";
	}
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("log_in", new Patients());
		return "login";
	}
	@GetMapping("/signUp")
	public String signUp(Model model){
		model.addAttribute("patient",new Patients());
		return "signup";
	}

}

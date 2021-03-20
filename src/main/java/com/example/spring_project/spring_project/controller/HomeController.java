package com.example.spring_project.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
//	@GetMapping("/hello")
//	public String read() {
//		return "index";
//	}
	
	@RequestMapping(value= "/betweb")
	public String read() {
		return "index";
	}
	
	@RequestMapping(value = "/home")
	public String Home() {
		return "home";
	}
}

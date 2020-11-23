package com.example.spring_project.spring_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerTest {
	
	@GetMapping("/")
	public String Home2() {
		return "Hello world";
	}
}

package com.huynh.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller	
public class HomeController {
	@GetMapping("/")
	private String home() {
		return "main.jsp";
	};
	
	@PostMapping("/infos")
	private String infos(@RequestParam("name") String name,
			@RequestParam("location") String location,
			@RequestParam("language") String language,
			@RequestParam("message") String message,
			Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("language", language);
		viewModel.addAttribute("message", message);
		return "result.jsp";
	};
			
}

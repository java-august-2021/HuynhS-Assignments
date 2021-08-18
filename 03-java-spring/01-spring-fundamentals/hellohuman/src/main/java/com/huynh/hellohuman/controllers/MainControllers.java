package com.huynh.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class MainControllers {
	@RequestMapping("/")
	private String greet() {
		return "index.jsp";
	};
	
	@RequestMapping("/{name}/{lastname}")
	private String personGreeting(@PathVariable("name") String name, @PathVariable("lastname") String lastname, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("lastname", lastname) ;
		return "human.jsp";
	};
}

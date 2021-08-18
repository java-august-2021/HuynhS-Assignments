package com.huynh.gettingfamiliarwithroutinng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	

	@RequestMapping("/")

	private String index() {
		return "index.jsp";
	}
	

	@RequestMapping(value="/tellJoke", method=RequestMethod.POST)
	private String jokeProcess(@RequestParam("name") String name, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("joke", joke);
		return "showjoke.jsp";
	};
	
	
	
	@RequestMapping("/{color}")
	private String colorValue(@PathVariable("color") String color, Model viewModel) {
		viewModel.addAttribute("color", color);
		return "color.jsp";
	};	
	
	
	
	
}

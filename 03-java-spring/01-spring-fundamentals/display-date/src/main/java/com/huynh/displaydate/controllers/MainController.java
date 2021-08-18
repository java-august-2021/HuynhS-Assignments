package com.huynh.displaydate.controllers;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalTime;

@Controller	
public class MainController {
	@RequestMapping("/")
	private String templates() {
		return "home.jsp";
	};
	
	@RequestMapping("/date")
	private String date(Model model) {
		LocalDate d = LocalDate.now();
		model.addAttribute("d",d);
		return "date.jsp";
	};
	
	@RequestMapping("/time")
	private String time(Model model) {
		LocalTime t = LocalTime.now();
		model.addAttribute("t", t);
		
		return "time.jsp";
	};
}

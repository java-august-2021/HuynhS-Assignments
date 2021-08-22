package com.huynh.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller	
public class MainController {
	@GetMapping("/")
	private String home(HttpSession session) {
		return "home.jsp";
	};
	
	@PostMapping("/getResult")
	private String result(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer total = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", total);
		}
		return "result.jsp";
	};
	
	@PostMapping("/reset")
	private String reset(HttpSession session) {
		session.invalidate();
		return "home.jsp";
	};
	

}

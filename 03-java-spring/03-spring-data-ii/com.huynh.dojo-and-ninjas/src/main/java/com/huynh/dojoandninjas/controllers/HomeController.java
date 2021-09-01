package com.huynh.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.huynh.dojoandninjas.models.Dojo;
import com.huynh.dojoandninjas.service.DojoService;
import com.huynh.dojoandninjas.service.NinjaService;

@Controller
public class HomeController {
	
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("ninjas", this.nService.ninjas());
		model.addAttribute("dojos", this.dService.allDojos());
		return "dashboard.jsp";
	}
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("allDojos", this.dService.allDojos());
		return "index.jsp";
	}
	
	@PostMapping("/newDojo")
	public String newDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			Dojo newDojo = this.dService.createOne(dojo);

			return "redirect:/";
		}
	}
	
	
}

package com.huynh.dojoandninjas.controllers;

import java.util.List;

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
import com.huynh.dojoandninjas.models.Ninja;
import com.huynh.dojoandninjas.service.DojoService;
import com.huynh.dojoandninjas.service.NinjaService;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService nService;
	@Autowired
	private DojoService dService;
	
	//get ninjas  & dojos
	@GetMapping("/ninjas")
	public String ninjas(@ModelAttribute("ninjas") Ninja ninja, Model model) {
		List<Dojo> allDojos = this.dService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninjas/ninjas.jsp";
	}
	
	
	//create ninja
	@PostMapping("/ninjas/create")
	public String createNewNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result) {
		if(result.hasErrors()) {
			return "ninjas/ninjas.jsp";
		}else {
			Ninja newNinja = this.nService.createOne(ninja);

			return "redirect:/";
		}
	}
	
	//get dojos infos
	
	@GetMapping("/getInfos/{id}")
	public String getInfos(@PathVariable Long id, Model model) {
		model.addAttribute("dojo", this.dService.getOne(id));
		return "ninjas/school_infos.jsp";
	}
}


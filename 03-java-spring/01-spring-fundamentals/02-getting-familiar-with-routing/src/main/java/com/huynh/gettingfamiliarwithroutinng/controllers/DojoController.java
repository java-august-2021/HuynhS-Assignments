package com.huynh.gettingfamiliarwithroutinng.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {
	@RequestMapping("/coding/{dojo}")
	private String dojo(@PathVariable(value="dojo") String dojo, Model viewModel)
	{
		viewModel.addAttribute("dojo", dojo);
		return "dojo.jsp";
	};
	
	
	@RequestMapping("/coding/dojo/at/{burbank}")
	private String burbank(@PathVariable(value="burbank") String burbank, Model viewModel)
	{
		viewModel.addAttribute("burbank", burbank);
		return "burbank.jsp";
	}
	
	
	@RequestMapping("/coding/dojo/at/{sanjose}/california")
	private String sanjose(@PathVariable(value="sanjose") String sanjose, Model viewModel)
	{
		viewModel.addAttribute("sanjose", sanjose);
		return "sanjose.jsp";
	}
	


}

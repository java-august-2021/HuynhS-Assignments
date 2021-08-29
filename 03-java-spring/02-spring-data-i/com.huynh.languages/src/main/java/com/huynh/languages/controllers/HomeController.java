package com.huynh.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.huynh.languages.models.Language;
import com.huynh.languages.services.LanguageServices;

@Controller


public class HomeController {
	@Autowired
	private LanguageServices langService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("languages", this.langService.allLanguages());
		return "home.jsp";
	}
	
	@GetMapping("/detail/{id}")
	public String detailPage(@PathVariable Long id, Model model) {
		Language lang = this.langService.oneLanguage(id);
		model.addAttribute("lang", lang);
		return "detail.jsp";
	}
	

	@GetMapping("/addpage")
	public String add(@ModelAttribute("language") Language lang) {
		return "addPage.jsp";
	}
	
	@PostMapping("/addNewLanguage")
	public String newLang(
			@Valid @ModelAttribute("language") Language lang,
			BindingResult result) {
		if(result.hasErrors()) {
			return "addPage.jsp";
		}
		else {
			this.langService.createLanguage(lang);
			return "redirect:/";
		}

	}
	
	@PostMapping("/deleteLanguage/{id}")
	public String deleteLang(
			@PathVariable("id") Long id) {
		this.langService.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/updatePage/{id}")
	public String updateCurrentLang(
			@ModelAttribute("language") Language lang,
			@PathVariable("id") Long id,
			Model model) {
		Language updateLang = langService.oneLanguage(id);
		model.addAttribute(updateLang);
		return "update.jsp";
	};
	
	@PostMapping("/edit/{id}")
	public String updateLang(
			@Valid @ModelAttribute("language") Language lang,
			BindingResult result) {
		if(result.hasErrors()) {
			return "update.jsp";
		}
		else {
			this.langService.update(lang);
			return "redirect:/";
		}

	}
}

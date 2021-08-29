package com.huynh.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huynh.languages.models.Language;
import com.huynh.languages.services.LanguageServices;

@RestController	
@RequestMapping("/api")
public class APIController {
	
	@Autowired
	private LanguageServices langService;
	
	@GetMapping("")
	public List<Language> allLanguages(){
		return this.langService.allLanguages();
	};
	
	@PostMapping("/create")
	public Language create(Language newLanguage) {
		return this.langService.createLanguage(newLanguage);
	};
	
	@GetMapping("/{id}")
	public Language oneLanguage(@PathVariable("id") Long id) {
		return this.langService.oneLanguage(id);
	}
	
	@PutMapping("/update/{id}")
	public Language updateLanguage(@PathVariable("id") Long id, Language updatedLanguage) {
		return this.langService.update(updatedLanguage);
	};
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.langService.delete(id);
	};
	
}

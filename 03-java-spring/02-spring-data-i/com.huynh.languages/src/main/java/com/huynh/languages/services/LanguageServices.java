package com.huynh.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.languages.models.Language;
import com.huynh.languages.repositories.LanguageRepo;

@Service

public class LanguageServices {

	@Autowired
	private LanguageRepo langRepo;
	
	// all
	
	public List<Language> allLanguages(){
		return this.langRepo.findAll();
	};
	
	//create
	
	public Language createLanguage(Language lang) {
		return this.langRepo.save(lang);
	}
	
	//detail
	
	public Language oneLanguage(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}
	//update
	
	public Language update(Language lang) {
		return this.langRepo.save(lang);
	}
	//delete
	
	public String delete(Long id) {
		this.langRepo.deleteById(id);
		return "Language" + id + "has been deleted";
	}
	
}

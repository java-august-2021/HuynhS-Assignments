package com.huynh.dojoandninjas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.dojoandninjas.models.Dojo;
import com.huynh.dojoandninjas.repository.DojoRepository;
import com.huynh.dojoandninjas.repository.NinjaRepository;

@Service
public class DojoService {
	@Autowired
	
	private DojoRepository dRepo;

	
	//find all
	
	public List<Dojo> allDojos(){
		return this.dRepo.findAll();
	}
	
	//create
	
	public Dojo createOne(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	
	//getOne
	
	public Dojo getOne(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	//deleteOne
	public String deleteOne(Long id) {
		this.dRepo.deleteById(id);
		return id + "was deleted";
	}
	//updateOne
	
	public Dojo updateOne(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
}

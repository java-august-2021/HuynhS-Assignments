package com.huynh.dojoandninjas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.dojoandninjas.models.Ninja;
import com.huynh.dojoandninjas.repository.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	
	private NinjaRepository nRepo;
	//all
	
	public List<Ninja> ninjas(){
		return this.nRepo.findAll();
	}
	
	//create

	public Ninja createOne(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	//find one
	
	public Ninja findOne(Long id) {
		return this.nRepo.findById(id).orElse(null);
	}
	
	//update one
	
	public Ninja updateOne(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	
	//delete one
	
	public String deleteOne(Long id) {
		this.nRepo.deleteById(id);
		return id + "was deleted";
	}
}

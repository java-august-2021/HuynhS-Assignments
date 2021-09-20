package com.huynh.greatideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huynh.greatideas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea,Long> {
	public List<Idea> findAll();
	

}

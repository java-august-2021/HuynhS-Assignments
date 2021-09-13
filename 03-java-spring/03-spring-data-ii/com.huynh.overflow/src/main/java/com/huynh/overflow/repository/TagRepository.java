package com.huynh.overflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huynh.overflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

	boolean existsBySubject(String subject);
	
	Tag findBySubject(String subject);
	
}

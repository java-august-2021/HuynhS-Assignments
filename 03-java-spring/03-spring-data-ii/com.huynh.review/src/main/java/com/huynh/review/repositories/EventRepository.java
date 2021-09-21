package com.huynh.review.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huynh.review.models.Event;



@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
	
	@Query(value="SELECT * from events", nativeQuery=true)
	public List<Event> findAll();
	
	List<Event> findByState(String state);
	List<Event> findByStateIsNot(String state);

}

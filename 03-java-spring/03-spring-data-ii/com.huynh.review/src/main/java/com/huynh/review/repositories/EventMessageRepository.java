package com.huynh.review.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huynh.review.models.EventMessage;

@Repository
public interface EventMessageRepository extends CrudRepository<EventMessage, Long> {

}

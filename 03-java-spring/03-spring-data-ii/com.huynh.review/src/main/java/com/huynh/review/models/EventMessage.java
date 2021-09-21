package com.huynh.review.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eventmessages")
public class EventMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private String eventMsg;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event oneEvent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User oneUser;

	public EventMessage() {
		super();
	}

	public EventMessage(String eventMsg, Event oneEvent, User oneUser) {
		super();
		this.eventMsg = eventMsg;
		this.oneEvent = oneEvent;
		this.oneUser = oneUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventMsg() {
		return eventMsg;
	}

	public void setEventMsg(String eventMsg) {
		this.eventMsg = eventMsg;
	}

	public Event getOneEvent() {
		return oneEvent;
	}

	public void setOneEvent(Event oneEvent) {
		this.oneEvent = oneEvent;
	}

	public User getOneUser() {
		return oneUser;
	}

	public void setOneUser(User oneUser) {
		this.oneUser = oneUser;
	}
	
	
}

package com.project.EventManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "event_planners")
public class EventPlanners {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventPlannerId;
	
	@ColumnDefault("'A'")
	private char record_status;
	
	private String name;
	private String email;
	private Long phoneNumber;
	@OneToOne(fetch = FetchType.EAGER)
    private Event event;
	
	public int getEventPlannerId() {
		return eventPlannerId;
	}
	public void setEventPlannerId(int eventPlannerId) {
		this.eventPlannerId = eventPlannerId;
	}
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public EventPlanners(int eventPlannerId, char record_status, String name, String email, Long phoneNumber,
			Event event) {
		super();
		this.eventPlannerId = eventPlannerId;
		this.record_status = record_status;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.event = event;
	}
	public EventPlanners() {
		super();
	}
	@Override
	public String toString() {
		return "EventPlanners [eventPlannerId=" + eventPlannerId + ", record_status=" + record_status + ", name=" + name
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", event=" + event + "]";
	}
	public EventPlanners(int eventPlannerId, String name, String email, Long phoneNumber, Event event) {
		super();
		this.eventPlannerId = eventPlannerId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.event = event;
	}
	
	
	
	
}
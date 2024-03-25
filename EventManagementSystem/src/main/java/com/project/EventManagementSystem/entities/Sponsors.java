package com.project.EventManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;

@Entity
public class Sponsors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sponsorId;
	
	@ColumnDefault("'A'")
	private char record_status;

	private String name;
	private String email;
	private Long mobileno;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Event event;

	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
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

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Sponsors(int sponsorId, char record_status, String name, String email, Long mobileno, Event event) {
		super();
		this.sponsorId = sponsorId;
		this.record_status = record_status;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.event = event;
	}

	public Sponsors() {
		super();
	}

	@Override
	public String toString() {
		return "Sponsors [sponsorId=" + sponsorId + ", record_status=" + record_status + ", name=" + name + ", email="
				+ email + ", mobileno=" + mobileno + ", event=" + event + "]";
	}

	public Sponsors(int sponsorId, String name, String email, Long mobileno, Event event) {
		super();
		this.sponsorId = sponsorId;
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.event = event;
	}
	
	

}
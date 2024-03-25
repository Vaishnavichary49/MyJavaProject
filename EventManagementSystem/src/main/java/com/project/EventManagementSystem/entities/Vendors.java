package com.project.EventManagementSystem.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "vendors")
public class Vendors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vendorId;

	@ColumnDefault("'A'")
	private char record_status;
	
	private String name;
	private String email;
	private Long mobileNo;
	private String service;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Event event;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Vendors(int vendorId, char record_status, String name, String email, Long mobileNo, String service,
			Event event) {
		super();
		this.vendorId = vendorId;
		this.record_status = record_status;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.service = service;
		this.event = event;
	}

	public Vendors() {
		super();
	}

	@Override
	public String toString() {
		return "Vendors [vendorId=" + vendorId + ", record_status=" + record_status + ", name=" + name + ", email="
				+ email + ", mobileNo=" + mobileNo + ", service=" + service + ", event=" + event + "]";
	}

	public Vendors(int vendorId, String name, String email, Long mobileNo, String service, Event event) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.service = service;
		this.event = event;
	}
	
	

}
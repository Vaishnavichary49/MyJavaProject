package com.project.EventManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;

	@ColumnDefault("'A'")
	private char record_status;

	private String eventName;
	private String date;
	private String time;
	private String location;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public char getRecord_status() {
		return record_status;
	}
	public void setRecord_status(char record_status) {
		this.record_status = record_status;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Event(int eventId, char record_status, String eventName, String date, String time, String location) {
		super();
		this.eventId = eventId;
		this.record_status = record_status;
		this.eventName = eventName;
		this.date = date;
		this.time = time;
		this.location = location;
	}
	public Event() {
		super();
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", record_status=" + record_status + ", eventName=" + eventName + ", date="
				+ date + ", time=" + time + ", location=" + location + "]";
	}
	public Event(int eventId, String eventName, String date, String time, String location) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.date = date;
		this.time = time;
		this.location = location;
	}
	
	

}
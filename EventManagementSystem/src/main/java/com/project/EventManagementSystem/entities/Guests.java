package com.project.EventManagementSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "guests")
public class Guests {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int guestId;
	    
	    @ColumnDefault("'A'")
		private char record_status;
	    
	  	private String name;
	    private String email;
	    private Long mobile_no;

	    @ManyToOne(fetch = FetchType.EAGER)
	    private Event event;

		public int getGuestId() {
			return guestId;
		}

		public void setGuestId(int guestId) {
			this.guestId = guestId;
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

		public Long getMobile_no() {
			return mobile_no;
		}

		public void setMobile_no(Long mobile_no) {
			this.mobile_no = mobile_no;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		public Guests(int guestId, char record_status, String name, String email, Long mobile_no, Event event) {
			super();
			this.guestId = guestId;
			this.record_status = record_status;
			this.name = name;
			this.email = email;
			this.mobile_no = mobile_no;
			this.event = event;
		}

		public Guests() {
			super();
		}

		@Override
		public String toString() {
			return "Guests [guestId=" + guestId + ", record_status=" + record_status + ", name=" + name + ", email="
					+ email + ", mobile_no=" + mobile_no + ", event=" + event + "]";
		}

		public Guests(int guestId, String name, String email, Long mobile_no, Event event) {
			super();
			this.guestId = guestId;
			this.name = name;
			this.email = email;
			this.mobile_no = mobile_no;
			this.event = event;
		}

	    
	    
		
}
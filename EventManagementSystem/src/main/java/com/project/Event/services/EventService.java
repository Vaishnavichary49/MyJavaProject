package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;

public interface EventService {

	 // Create (Save)
	  public boolean saveEvent(Event event);

	  // Read (Find)
	  public Event findById(int eventId);

	  // Update
	  public boolean updateEvent(int eventId, String name, String time, String date, String location);

	  // Delete
	  public boolean deleteEvent(int eventId);

	  // Find all events
	  public List<Event> getAllEvents();
}



package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.EventPlanners;

public interface EventPlannersService {
	// Create (Save)
	public boolean saveEventPlanner(EventPlanners eventPlanner);

	// Read (Find)
	public EventPlanners findById(int eventPlannerId);

	// Update
	public boolean updateEventPlanner(int eventPlannerId, String name, String email, Long phoneNumber, Event event);

	// Delete
	public boolean deleteEventPlanner(int eventPlannerId);

	// Find all eventPlanners
	public List<EventPlanners> getAllEventPlanners();

}

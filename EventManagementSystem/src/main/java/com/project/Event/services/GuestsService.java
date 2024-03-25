package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Guests;

public interface GuestsService {

	// Create (Save)
	public boolean saveGuest(Guests guest);

	// Read (Find)
	public Guests findById(int guestId);

	// Update
	public boolean updateGuest(int guestId, String name, String email, Long mobileNumber, Event event);

	// Delete
	public boolean deleteGuest(int guestId);

	// Find all guests for a specific event
	public List<Guests> findGuestsByEventId(int eventId);
}

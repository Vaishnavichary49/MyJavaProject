package com.project.EventManagementSystem.dao;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Sponsors;

public interface SponsorsDAO {

  // Create (Save)
  public boolean saveSponsor(Sponsors sponsor);

  // Read (Find)
  public Sponsors findById(int sponsorId);

  // Update
  public boolean updateSponsor(int sponserId, String name, String email, Long mobileNumber, Event event);

  // Delete
  public boolean deleteSponsor(int sponsorId);

  // Find all sponsors associated with an event
  public List<Sponsors> findSponsorsByEventId(int eventId);
  
}

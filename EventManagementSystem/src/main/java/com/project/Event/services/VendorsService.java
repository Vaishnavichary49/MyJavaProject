package com.project.Event.services;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Vendors;

public interface VendorsService {

	// Create (Save)
	public boolean saveVendor(Vendors vendor);

	// Read (Find)
	public Vendors findById(int vendorId);

	// Update
	public boolean updateVendor(int vendorId, String name, String email, Long mobileNumber, String service,
			Event event);

	// Delete
	public boolean deleteVendor(int vendorId);

	// Find all vendors
	public List<Vendors> getAllVendors();
}

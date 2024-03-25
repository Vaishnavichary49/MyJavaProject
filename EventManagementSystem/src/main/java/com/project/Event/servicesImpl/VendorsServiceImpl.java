package com.project.Event.servicesImpl;

import java.util.List;

import com.project.EventManagementSystem.entities.Event;
import com.project.EventManagementSystem.entities.Vendors;
import com.project.Event.services.VendorsService;
import com.project.EventManagementSystem.dao.VendorsDAO; // Assuming VendorsDAO interface exists
import com.project.EventManagementSystem.daoImpl.VendorsDAOImpl;

public class VendorsServiceImpl implements VendorsService {

	VendorsDAO vendorsDao = new VendorsDAOImpl();
	
	@Override
	public boolean saveVendor(Vendors vendor) {
		return vendorsDao.saveVendor(vendor);
	}

	@Override
	public Vendors findById(int vendorId) {
		return vendorsDao.findById(vendorId);
	}

	@Override
	public boolean updateVendor(int vendorId, String name, String email, Long mobileNumber, String service,
			Event event) {
		return vendorsDao.updateVendor(vendorId, name, email, mobileNumber, service, event);
	}

	@Override
	public boolean deleteVendor(int vendorId) {
		return vendorsDao.deleteVendor(vendorId);
	}

	@Override
	public List<Vendors> getAllVendors() {
		return vendorsDao.getAllVendors();
	}

    
}
